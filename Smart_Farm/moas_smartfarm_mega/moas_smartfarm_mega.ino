#include <DHT.h>//DHT 라이브러리 불러오기
#include <Adafruit_NeoPixel.h> //네오픽셀 라이브러리 불러오기

//1층 핀설정
#define ledPin 13
#define soilSensor A0
#define dhtSensor 8
#define fanA 5
#define fanB 6  
#define fanPWM 7  
#define pumpA 3
#define pumpB 4
#define pumpPWM 2
DHT dht(dhtSensor, DHT11);

//LED 관련
int ledNumber = 14*9;
int R=1, G=2, B=3, O=4, W=5, i, j;
int Kale[]={R,R,B,R}, SC[]={R,R,R,R,B,R},Gl[]={R,R,R,R,R,R,B,R},Off[]={O},White[]={W,B,B,G,R};
Adafruit_NeoPixel strip = Adafruit_NeoPixel(ledNumber, ledPin, NEO_GRB +NEO_KHZ800);

//식물 관련
int plantNumber = 1;
int temp, humi, soil;
int TEM[]={0,25,25,25,25,25,25,25};
int HUM[]={0,60,60,60,60,60,60};

void setup(){
    pinMode(fanA, OUTPUT);
    pinMode(fanB, OUTPUT);
    pinMode(fanPWM, OUTPUT);
    pinMode(pumpA, OUTPUT);
    pinMode(pumpB, OUTPUT);
    pinMode(pumpPWM, OUTPUT);
    strip.begin();
    Serial.begin(115200); //시리얼 통신속도
}

void loop(){
  if(Serial.available()){
    plantNumber = Serial.parseInt();
    Serial.println(plantNumber);}
   
   if (plantNumber >= 100){
       Manual(plantNumber);}

   else {
   Auto(plantNumber);
   String serialADD = serial(humi,temp,soil);
   Serial.println(serialADD);
   }
}

String serial(int H,int T, int M){
  String strAdd = 'Q'+ String(H) + String(T) +  String(M);
  return strAdd;
}

void Fan(int veg){
  humi = dht.readHumidity();       // 습도값을 temp에 저장
  temp = dht.readTemperature();    // 온도값을 humi에 저장

  if(temp > TEM[veg]){             //층의 온도 > TEM (정해진 온도)
    digitalWrite(fanA,HIGH);
    digitalWrite(fanB,LOW);
    analogWrite(fanPWM,200);}
  else {                           //정지
    digitalWrite(fanA, LOW);
    digitalWrite(fanB, LOW);}
    delay(300);  
}

void Pump(int veg){
   int soilIN = analogRead(soilSensor);
   soil = map(soilIN,0,1024,0,100);  //토양수분값을 soil에 저장
  if(soil < HUM[veg]){             //층의 토양수분 < HUM(정해진 토양수분값)
    digitalWrite(pumpA,HIGH);
    digitalWrite(pumpB,LOW);
    analogWrite(pumpPWM,255);}
  else {                           //정지
    digitalWrite(pumpA, LOW);
    digitalWrite(pumpB, LOW);}
    delay(300);
}

void Led(int Crops_name[], int lp){
  for (int i=0; i<=ledNumber; i += lp){       //led pattern ledNumber까지 반복
    for (int j=0; j<lp; j++){                 //하나의 led pattern
      if (Crops_name[j]==R){strip.setPixelColor(i+j,255,0,0);}
      if (Crops_name[j]==B){strip.setPixelColor(i+j,0,0,255);}
      if (Crops_name[j]==G){strip.setPixelColor(i+j,0,255,0);}
      if (Crops_name[j]==O){strip.setPixelColor(i+j,0,0,0);}
      if (Crops_name[j]==W){strip.setPixelColor(i+j,255,255,255);}
      strip.show();}}
}

void Auto(int veg){                //자동 제어
  Fan(veg);
  Pump(veg);
  switch(veg){
    case 1:
    Led(SC,sizeof(SC)/2);          //상추
    break;
    case 2:
    Led(Gl,sizeof(Gl)/2);          //부추
    break;
    case 3:
    Led(Gl,sizeof(Gl)/2);          //달래
    break;
    case 4:
    Led(Kale,sizeof(Kale)/2);      //깻잎
    break;
    case 5:
    Led(Kale,sizeof(Kale)/2);      //케일
    break;
    case 6:
    Led(Gl,sizeof(Gl)/2);          //시금치
    break;
    case 7:
    Led(White,sizeof(White)/2);    //무순
    break;
  }
}

void Manual(int veg){             //수동제어
  switch(veg){
    case 100:
      digitalWrite(pumpA, HIGH);
      digitalWrite(pumpB, LOW);
      analogWrite(pumpPWM, 255);
         break;
    case 101:
      digitalWrite(pumpA, LOW);
      digitalWrite(pumpB, LOW);
      break;
    case 102:
      digitalWrite(fanA, HIGH);    
      digitalWrite(fanB, LOW);
      analogWrite(fanPWM, 255);
      break;
    case 103:
      digitalWrite(fanA, LOW);    
      digitalWrite(fanB, LOW);
      break;
    case 104:
      Led(Kale,sizeof(Kale)/2);
      Led(Kale,sizeof(Kale)/2);
      break;
    case 105:
      Led(SC,sizeof(SC)/2);
      Led(SC,sizeof(SC)/2);
      break;
    case 106:
      Led(Gl,sizeof(Gl)/2);
      Led(Gl,sizeof(Gl)/2);
      break;
    case 107:
      Led(Off,sizeof(Off)/2);
      Led(Off,sizeof(Off)/2);
      break;
    case 108:
      Led(White,sizeof(White)/2);
      Led(White,sizeof(White)/2);
      break;
  }
}
