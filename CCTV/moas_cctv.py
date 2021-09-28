from selenium import webdriver
import RPi.GPIO as GPIO
import time
import datetime
import webbrowser
import numpy as np
from selenium.webdriver.chrome.options import Options
import firebase_admin
from firebase_admin import credentials
from firebase_admin import storage
from firebase_admin import db
from uuid import uuid4
import socket

PROJECT_ID = "nodemcutest-756bb"
cred = credentials.Certificate("/home/pi/Downloads/nodemcutest-756bb-firebase-adminsdk-ba44u-e1505cd694.json")
firebase_admin.initialize_app(cred,{'databaseURL':'https://nodemcutest-756bb-default-rtdb.firebaseio.com/', 'storageBucket':f"{PROJECT_ID}.appspot.com"})

bucket = storage.bucket() #storage 기본 버킷 사용
#GPIO 설정
sensor = 17
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(sensor ,GPIO.IN)
print ("Waiting for a sensor")
time.sleep(2)

def ipcheck(): #socket모듈을 이용하여 ip를 확인 
    st = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    try:       
        st.connect(('10.255.255.255', 1))
        IP = st.getsockname()[0]
    except Exception:
        IP = '127.0.0.1'
    finally:
        st.close()
    return IP


def fileUpload(file):
    blob = bucket.blob('cctv'+file) #저장한 사진을 파이어베이스 storage 에 올려줌 
    #new token and metadata 설정
    new_token = uuid4()
    metadata = {"firebaseStorageDownloadTokens": new_token} #access token이 필요하다.
    blob.metadata = metadata
 
    #upload file
    blob.upload_from_filename(filename='/home/pi/Desktop/webOS/'+file, content_type='image/png') #파일이 저장된 주소와 이미지 형식(jpeg도 됨)
    #debugging hello
    print(blob.public_url)
 

while(True):
    if GPIO.input(sensor):
        print("Motion Detected")
        time.sleep(0.1)
        wd = webdriver.Chrome('/usr/lib/chromium-browser/chromedriver')
        url = 'http://' + ipcheck() + ':8090/stream_simple.html'
        wd.get(url)
        filename = datetime.datetime.now().strftime("%Y%m%d_%H%M%S") + '.png'
        wd.save_screenshot(filename)
        wd.quit()
        
        fileUpload(filename)
        
        ref = db.reference('CCTV')
        ref.update({'human':'detected'})
        ref.update({'ip': url})
        
    else:
        print("Motion not Detected")
        ref = db.reference('CCTV')
        ref.update({'human':'no'})
        time.sleep(0.1)





