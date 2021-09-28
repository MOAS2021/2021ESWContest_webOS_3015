import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import serial
import time
import socket

cred = credentials.Certificate("/home/pi/Downloads/nodemcutest-756bb-firebase-adminsdk-ba44u-9c1e26b836.json")
firebase_admin.initialize_app(cred,{'databaseURL': 'https://nodemcutest-756bb-default-rtdb.firebaseio.com/'})
s = serial.Serial('/dev/ttyACM0', 115200)

def ipcheck():
    st = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    try:       
        st.connect(('10.255.255.255', 1))
        IP = st.getsockname()[0]
    except Exception:
        IP = '127.0.0.1'
    finally:
        st.close()
    return IP

while(True):
    if s.readable():
        A = s.readline()
        A = A.decode()
        A = str(A)
        if A[0]=='Q':
            HUM=str(A[1:3])   #1층 습도 문자열  
            TEM=str(A[3:5])   #1층 온도 문자열 
            SOIL=str(A[5:7])   #1층 토양수분 문자열
            ref1 = db.reference().child('Smartfarm/THS')
        ref1.update({'h' : HUM}) #해당 변수가 없으면 생성한다.
        ref1.update({'t' : TEM}) 
        ref1.update({'s' : SOIL})
        url = 'http://' + ipcheck() + ':8090/stream_simple.html'
        ref2 = db.reference('Smartfarm')
        ref2.update({'ip': url})
        
    ref = db.reference().child('Smartfarm/plantNumber')
    print(ref.get())
    r = ref.get()
    r = r.encode('utf-8')
    s.write(r)
    time.sleep(0.5)



