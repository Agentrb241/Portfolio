int r1a =7;
int r1b=6;
int r1c= 8;
int r2a = 5;
int r2b=4;
int r2c = 9;
int r3=3;
float hold_current;
float voltage1,voltage2,current;
float temp_value;
int x = 0;

//func prototyping 
void key_display();
float voltagefunc_sensor1();
float  voltagefunc_sensor2();
float Read_temp_battery();
float Read_temp1();
float Read_temp2(); 
float read_realay_state();
//void relay_on();
void relay_off();
float read_realay_state();
float Read_temp1();
float Read_temp2();
float current_sensorf();


//sensor pin assignments. 

//temperature sensor at A0
float temp_sensor_battery=A0;

//temperature sensor shairing 
float temp_sensor1 =A2;
//float temp_sensor_vcc1 = A2;

//temerature sensor shairing A1
float temp_sensor2 = A1;
//float temp_sensor_vcc2=A1;

//voltage sensor 
float voltage_sensor1=A5; //voltage going into battery
float voltage_sensor2=A3; //battery voltage

//current sensor 
float current_sensor=A4; //current going into battery

//time totaler
long time1;
long time2;
long time3;


void setup() {
Serial.begin(9600);
 pinMode(r1a,OUTPUT);
 pinMode(r1b,OUTPUT);
 pinMode(r1c,OUTPUT);
 pinMode(r2a,OUTPUT);
 pinMode(r2b,OUTPUT);
 pinMode(r2c,OUTPUT);
 pinMode(r3,OUTPUT);
Serial.println("Enter T for Temperature");
Serial.println("Enter C for Current");
Serial.println("Enter V for Voltage");
Serial.println("Enter R for Relay State");
Serial.println("Enter O for Turn off all Relay");
Serial.println("Enter 1 for Current");
Serial.println("Enter 2 for Voltage");
Serial.println("Enter 3 for Discharge");
  // setup code here, to run once:

}

void loop() {

  key_display();
  // main code here, to run repeatedly:

voltagefunc_sensor1();
voltagefunc_sensor2();
current_sensorf();

 float bat_temp = Read_temp_battery();

 float temp1 = Read_temp1();

float temp2 = Read_temp2();

 if (temp2 > 35)
 {
  Serial.println(" opamp 1 too hot");
  relay_off();
  }

 if (temp1 > 35)
 {
  Serial.println(" opamp 2 too hot");
   relay_off();
 }

 if (bat_temp > 35)
 {
  Serial.println(" battery too hot");
  relay_off();
 }
 
}

//relay on function 

//void relay_on()
//{
// digitalWrite(r1a,HIGH);
// digitalWrite(r1b,HIGH);
 //digitalWrite(r2a,HIGH);
 //digitalWrite(r2b,HIGH);
 //digitalWrite(r3,HIGH);
//}

//relay off function 
void relay_off()
{
 
 digitalWrite(r1a,LOW);
 digitalWrite(r1b,LOW);
 digitalWrite(r1c,LOW);
 digitalWrite(r2a,LOW);
 digitalWrite(r2b,LOW);
 digitalWrite(r2c,LOW);
 digitalWrite(r3,LOW);
 int x = 0;
 
}


//readoing realay states 
float read_realay_state()
{
  if ( r1a == 1 && r1b == 1 && r1c == 1){
    Serial.println("Current opperational");
  } else if ( r2a == 1 && r2b == 1 && r2c == 1){
    Serial.println("Voltage opperational");
  }else if (r3 == 1){
    Serial.println("Discharge opperational");
  }
  

}
//end of checking states for relays



//voltage sensor1 funcation 
//voltage sensor vcc circuit 
float voltagefunc_sensor1()
{
  float volt_value1=analogRead(voltage_sensor1);
  float volt_valueraw1 = (volt_value1/1010)*25;
  if (volt_valueraw1>1.55)
  {
    relay_off();
  Serial.println("Charging Voltage too high");
  Serial.println(volt_valueraw1);
   }
  if (volt_valueraw1==1.45)
  {
     Serial.println("Battery Charging Low");
  }
  else 
  return(volt_valueraw1);
}

//voltage senosr 2 function 
//voltage sensor in battery
float voltagefunc_sensor2()
{
  float volt_value3=analogRead(voltage_sensor2);
  float volt_valueraw2 = (volt_value3/1010)*25;
   if (volt_valueraw2==1.2)
  {
     relay_off();
     Serial.println("Battery Fully Charged");
     
  }
  else 
   return(volt_valueraw2);
}

//Temperature sensors:


float Read_temp2()
{

  int rawvoltagevcc2 = analogRead(temp_sensor2);
  float millivolts2 = (rawvoltagevcc2 / 1024.0) * 5000;
  float celsius2 = millivolts2 / 10;
  return(celsius2);
  
}


float Read_temp1()
{

  int rawvoltageccc1 = analogRead(temp_sensor1);
  float millivolts3 = (rawvoltageccc1 / 1024.0) * 5000;
  float celsius3 = millivolts3 / 10;
  return(celsius3);
}


float Read_temp_battery()
{
  int rawtempbattery = analogRead(temp_sensor_battery);
  float degree_battery = (rawtempbattery / 1024.0) * 5000;
  float celsius5 = degree_battery / 10;
  return(celsius5); 
}

//current sensor coding 
float current_sensorf()
{
float current = analogRead(current_sensor);
 float v= .0048828125 * current;
 v -= 2.5;
 float amps = v / .066;
 amps = current;
 if (current > .15){
  relay_off();
  Serial.println("current too high");
  Serial.println(current);
 }
 if (current < .09) {
  relay_off();
 Serial.println("current low");
 Serial.println(current);
 }
 return (current);
}

void key_display(){
 while (Serial.available()) {
    char inChar = (char)Serial.read();
    if (inChar == 'T') {
     float tep1 =Read_temp1();
     float tep2 = Read_temp2();
     float tep3 = Read_temp_battery();
     
      Serial.println(tep1);
      Serial.println(tep2);
      Serial.println(tep3);
    }
    if(inChar == 'V'){
      float volts1 = analogRead(voltage_sensor1);
      Serial.println(volts1);
     
      float volts2 =analogRead(voltage_sensor2);
      float vbat= (volts2/1000)*25;
      Serial.println(vbat);
    }


     if (inChar == 'R') {
    
     if ( x == 1 ){
      Serial.println("Current opperational");
     } else if ( x == 2 ){
      Serial.println("Voltage opperational");
     }else if (x == 3 ){
      Serial.println("Discharge opperational");
     } else if (x == 0 ){
      Serial.println("Everything is turned off");
     } 
     }
     if (inChar == 'C') {

      float volts3 =analogRead(voltage_sensor1);
      float vres= (volts3/1000)*25;
     float curr1 = vres/100;
     Serial.println(vres, 3);
     Serial.println(curr1, 3);
     }
     if (inChar == '0') {
      relay_off();
      Serial.println("All relays turned off");
     }
     if (inChar == '2') {
       digitalWrite(r1a,LOW);
       digitalWrite(r1b,LOW);
       digitalWrite(r1c,LOW);
       digitalWrite(r3,LOW);
       digitalWrite(r2a,HIGH);
       digitalWrite(r2b,HIGH);
       digitalWrite(r2c,HIGH);
        x = 2;
       Serial.println("Voltage Circuit Turned On");
     }
     if (inChar == '1') {
       digitalWrite(r1a,HIGH);
       digitalWrite(r1b,HIGH);
       digitalWrite(r1c,HIGH);
       digitalWrite(r3,LOW);
       digitalWrite(r2a,LOW);
       digitalWrite(r2b,LOW);
       digitalWrite(r2c,LOW);
        x = 1;
       Serial.println("Current Circuit Turned On");
     }
     if (inChar == '3') {
       digitalWrite(r1a,LOW);
       digitalWrite(r1b,LOW);
       digitalWrite(r1c,LOW);
       digitalWrite(r3,HIGH);
       digitalWrite(r2a,LOW);
       digitalWrite(r2b,LOW);
       digitalWrite(r2c,LOW);
       x = 3;
       Serial.println("Discharge Circuit Turned On");
     }   
  }
}
