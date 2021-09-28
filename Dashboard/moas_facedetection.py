import cv2
import numpy as np
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

 

PROJECT_ID = "nodemcutest-756bb"
cred = credentials.Certificate("/home/pi/Downloads/nodemcutest-756bb-firebase-adminsdk-ba44u-e1505cd694.json")
firebase_admin.initialize_app(cred,{'databaseURL':'https://nodemcutest-756bb-default-rtdb.firebaseio.com/'})

 

def yolo(frame, size): 
    # yolo에 쓰이는 파일 불러오기 
    net = cv2.dnn.readNet(f"/home/pi/darknet/backup/yolo-obj_1_final.weights","/home/pi/darknet/data/yolo-obj_1.cfg")
    layer_names = net.getLayerNames()
    output_layers =[layer_names [i[0]-1] for i in net.getUnconnectedOutLayers()]
      # 클래스의 개수만큼 랜덤 색 받아오기 
    colors = np.random.uniform(0,255,size=(len(classes),3))
     # 이미지의 높이, 넓이 받아오기 
    height, width, channels =frame.shape
      # 네트워크에 넣기 위한 전처리
    blob = cv2.dnn.blobFromImage(frame, 0.00392, (size,size), (0,0,0), True, crop=False)
      # 전처리된 blob 네트워크에 입력
    net.setInput(blob)
     # 감지결과  탐지된 개체에 대한 모든 정보와 위치
    outs = net.forward(output_layers)

     # 각각의 데이터를 저장할 빈 리스트
    class_ids = []
    confidences = []
    boxes = []

 

    for out in outs:
        for detection in out:
            scores = detection[5:]
            class_id = np.argmax(scores)
            confidence = scores[class_id]

            if confidence > 0.8:  # 신뢰도가 0.8 이상일때 
                  # 탐지된 객체의 넓이, 높이, 중심 찾기
                center_x = int(detection[0] * width)
                center_y = int(detection[1] * height)
                w = int(detection[2] * width)
                h = int(detection[3] * height)
                  # 객체의 사각형 테두리 중 왼쪽 위 좌표값 찾기
                x = int(center_x - w / 2)
                y = int(center_y - h / 2)  
                boxes.append([x, y, w, h])
                confidences.append(float(confidence))
                class_ids.append(class_id)

    #겹쳐있는 박스 중 신뢰도가 가장 높은 박스를 선택 (노이즈 제거)
    indexes = cv2.dnn.NMSBoxes(boxes, confidences, 0.5, 0.4)

    for i in range(len(boxes)):
        if i in indexes:
            x, y, w, h = boxes[i] 
            class_name = classes[class_ids[i]]
            # 얼굴 인식 되었을 경우 파이어베이스로 이름 보내줌 
            ref1 = db.reference('FaceCheck')
            ref1.update({'Name': class_name})
            #이름과 신뢰도를  label로  지정해줌 
            label = f"{class_name} {confidences[i]:.2f}"
            #아이디마다 다른색 
            color = colors[class_ids[i]]
            #박스랑 텍스트 적어줌 
            cv2.rectangle(frame, (x, y), (x + w, y + h), color, 2)  
            cv2.rectangle(frame, (x - 1, y), (x + len(class_name) * 13 + 65, y - 25), color, -1)
            cv2.putText(frame, label, (x, y - 8), cv2.FONT_HERSHEY_COMPLEX_SMALL, 1, (0, 0, 0), 2)
            #이름과 신뢰도 표시 
            print(f"{class_name}, conf: {confidences[i]} ")
        return frame

classes = ["ii","i","mj"]
cap =cv2.VideoCapture(0)
cap.set(3,640)
cap.set(4,480)

while True:
    ref = db.reference().child('FaceCheck/Power')  
    r = ref.get()
    # 얼굴인식 on 값이 들어왔을 때 
    if r == "ON":
        ret, img = cap.read()  
        img = cv2.flip(img, 1) 
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY) # 흑백으로 변환 
        frame = yolo(frame=img, size=416) # 웹캠으로 찍히는 이미지에서 인식 시작 
        cv2.imshow("Output_Yolo", frame) # 웹캠 화면 띄움  
        k = cv2.waitKey(10) & 0xff 
        if k == 27:
            break

    else:
        ref1 = db.reference('FaceCheck')
        ref1.update({'Name': '0'})

    

cap.release()
cv2.destroyAllWindows() 