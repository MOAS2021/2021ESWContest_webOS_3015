#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>

#define WIFI_SSID "MoASAoM"
#define WIFI_PASSWORD "moasdamoas"
#define FIREBASE_HOST "nodemcutest-756bb-default-rtdb.firebaseio.com/"
#define FIREBASE_AUTH "TZi57cOdFMbRWmHewGGWbLPteX1WFXnw8zl778t1"

#define rainwaterSensor D7
#define dustSensor A0

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
  Firebase.setwriteSizeLimit(fbdo, "medium");

  //선택사항, 데이터베이스에 저장할 float 및 double data의 소수 자릿수를 설정합니다.
  Firebase.setFloatDigits(2);
  Firebase.setDoubleDigits(6);
  //------------------------------------------------------------------------------핀모드 설정------------------------------------------------------------------------------//
  pinMode(rainwaterSensor,INPUT);
  pinMode(dustSensor,INPUT);
  Firebase.setInt(fbdo,"/Window/Control/PositionValue",0);
}

void loop() {
  if (Firebase.getInt(fbdo, "/Window/Control/PositionValue")){
    int positionValue = fbdo.intData();
    switch(positionValue){
      case 0:
        Firebase.setString(fbdo,"/Window/Control/Position","Close");
        Serial.println(1234);
        break;
      case 1:
        Firebase.setString(fbdo,"/Window/Control/Position","Open");
        Serial.println(4321);
        break;
     }
  }
  else {
    Serial.println(fbdo.errorReason());
  }
  Dust();
  Rainwater();
}

void Dust(){
  int dust = analogRead(A0);
  float voltage = dust / 1024 * 5.0;
  float dustDensityug = (voltage - 0.3) / 0.005;
  Firebase.setFloat(fbdo,"/Window/Sensor/Dust/DustValue",abs(dustDensityug));
  String evaluation ="JHJH";
  if(dustDensityug <= 30.0){       // 대기 중 미세먼지가 좋음 일 때
    evaluation="좋음";
  }
  else if(30.0 < dustDensityug && dustDensityug <= 80.0){      // 대기 중 미세먼지가 보통 일 때
    evaluation="보통";
  }
  else if (80.0 < dustDensityug && dustDensityug <= 150.0){    // 대기 중 미세먼지가 나쁨 일 때
    evaluation="나쁨";
  }
  else{                                                     // 대기 중 미세먼지가 매우 나쁨 일 때
    evaluation="매우나쁨";
  }
  Firebase.setString(fbdo,"/Window/Sensor/Dust/Evaluation",evaluation);
}

void Rainwater(){
  String rainwater = digitalRead(rainwaterSensor)?"없음":"있음";
  Firebase.setString(fbdo,"/Window/Sensor/Rainwater",rainwater);
}
