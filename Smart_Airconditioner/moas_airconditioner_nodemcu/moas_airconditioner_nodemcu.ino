#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>
#include <DHT.h>
#define WIFI_SSID "MoASAoM"
#define WIFI_PASSWORD "moasdamoas"
#define FIREBASE_HOST "nodemcutest-756bb-default-rtdb.firebaseio.com/"
#define FIREBASE_AUTH "TZi57cOdFMbRWmHewGGWbLPteX1WFXnw8zl778t1"

#define motor_A D5
#define motor_B D6
#define motor_P D7
DHT dht(D1, DHT11);
//Define FirebaseESP8266 data object
FirebaseData fbdo;

FirebaseJson json;

void printResult(FirebaseData &data);

void setup(){
  Serial.begin(115200);

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED){
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);
  
  //대용량 데이터로 작업하려는 경우 WiFi/tx 버퍼의 크기를 설정합니다.
  fbdo.setBSSLBufferSize(1024, 1024); 

  //대용량 데이터로 작업하려는 경우 HTTP 응답 버퍼의 크기를 설정합니다.
  fbdo.setResponseSize(1024);

  //데이터베이스 읽기 제한 시간을 1분으로 설정(최대 15분)
  Firebase.setReadTimeout(fbdo, 1000 * 60); 

  //크기 및 쓰기 시간 제한 (예: tiny (1초), small (10초), medium (30초), large (60초), unlimited(무제한))
  Firebase.setwriteSizeLimit(fbdo, "tiny");

  //선택사항, 데이터베이스에 저장할 float 및 double data의 소수 자릿수를 설정합니다.
  Firebase.setFloatDigits(2);
  Firebase.setDoubleDigits(6);
  //------------------------------------------------------------------------------핀 모드 설정------------------------------------------------------------------------------//
  pinMode(motor_A,OUTPUT);
  pinMode(motor_B,OUTPUT);
  pinMode(motor_P,OUTPUT);
  digitalWrite(motor_B,LOW);
  dht.begin();
}

void loop(){
  if (Firebase.getInt(fbdo, "/Airconditioner/Control/PowerValue")){
    int positionValue = fbdo.intData();
    switch(positionValue){
      case 0:
        Firebase.setString(fbdo,"/Airconditioner/Control/Power","OFF");
        digitalWrite(motor_A,LOW);
        break;
      case 1:
        Firebase.setString(fbdo,"/Airconditioner/Control/Power","ON");
        digitalWrite(motor_A,HIGH);
        if (Firebase.getInt(fbdo, "/Airconditioner/Control/ForceValue")){
          int forceValue = fbdo.intData();
          switch(forceValue){
            case 0:
              Firebase.setString(fbdo,"/Airconditioner/Control/Force","하");
              analogWrite(motor_P,500);
              break;
            case 1:
              Firebase.setString(fbdo,"/Airconditioner/Control/Force","중");
              analogWrite(motor_P,800);
              break;
            case 2:
              Firebase.setString(fbdo,"/Airconditioner/Control/Force","상");
              analogWrite(motor_P,1024);
              break;
              }
            }
         else{
          Serial.println(fbdo.errorReason());
          }
          break;
       }
    }
 else{
  Serial.println(fbdo.errorReason());
  }
  TempHumi();
}

void TempHumi(){
  int temp = dht.readTemperature();       // 습도값을 temp에 저장
  int humi = dht.readHumidity();   // 온도값을 humi에 저장
  Firebase.setInt(fbdo,"/Airconditioner/TempHumi/t",temp);
  Firebase.setInt(fbdo,"/Airconditioner/TempHumi/h",humi);
  delay(1000);
}
