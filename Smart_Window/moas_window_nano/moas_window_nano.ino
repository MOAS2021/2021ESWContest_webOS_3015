#define motorDir 2
#define motorStep 3
#define openSW 4
#define closeSW 5

int stepTime=6500;
long numA = 1004;
long numB = 1004;
void setup() {
  pinMode(motorDir,OUTPUT);
  pinMode(motorStep,OUTPUT);
  pinMode(openSW,INPUT);
  pinMode(closeSW,INPUT);
  Serial.begin(115200);
  motorClose();
}

void loop() {
  if(Serial.available()){
    numA = Serial.parseInt();
    if(numA!=numB){
      switch(numA){
        case 1234:
          motorClose();
          break;
        case 4321:
          motorOpen();
          break;
        case 0:
          numA=numB;
          break;
      }
     numB=numA;
    }
  }
}

void motorClose(){
  digitalWrite(motorDir,LOW);
  while(digitalRead(closeSW)==HIGH){
    digitalWrite(motorStep,HIGH);
    delayMicroseconds(stepTime);
    digitalWrite(motorStep,LOW);
    delayMicroseconds(stepTime);
    }
}

void motorOpen(){
  digitalWrite(motorDir,HIGH);
  while(digitalRead(openSW)==HIGH){
    digitalWrite(motorStep,HIGH);
    delayMicroseconds(stepTime);
    digitalWrite(motorStep,LOW);
    delayMicroseconds(stepTime);
    }
}
