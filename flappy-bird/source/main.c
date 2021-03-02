//ledmatrix7219d88 output example

#include <stdio.h>
#include <avr/io.h>
#include <avr/interrupt.h>

#define F_CPU 1000000UL  // 1 MHz
#include <util/delay.h>
#include "ledmatrix7219d88.h"
//#include "ledmatrix7219d88.c"
//#include "max7219.c"
//#include "max7219.h"

enum joystick_States{init, wait, act, waitOff, gameOver} j_state = init;
enum matrix_States{normal, over, finish} m_state = normal;
enum reset_States{wait1, rst, wait2} r_state = wait1;

uint8_t game[118] = {
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11000111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11111011,
	0b00000000,
	0b00000000,
	0b00000000,
	0b01111111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11101111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b10111111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11111101,
	0b00000000,
	0b00000000,
	0b00000000,
	0b10111111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11111110,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11101111,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11011111,
	0b00000000,
	0b00000000,
	0b11111101,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11001111,
	0b00000000,
	0b00000000,
	0b11111011,
	0b00000000,
	0b00000000,
	0b01111111,
	0b00000000,
	0b00000000,
	0b11101111,
	0b00000000,
	0b00000000,
	0b10111111,
	0b00000000,
	0b00000000,
	0b11111101,
	0b00000000,
	0b00000000,
	0b11011111,
	0b00000000,
	0b00000000,
	0b11111011,
	0b00000000,
	0b00000000,
	0b11101111,
	0b00000000,
	0b00000000,
	0b11011111,
	0b00000000,
	0b00000000,
	0b11111110,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b00000000,
	0b11101111,
	0b00000000,
	0b11111011,
	0b00000000,
	0b11011111,
	0b00000000,
	0b11101111,
	0b00000000,
	0b10111111,
	0b00000000,
	0b01111111,
	0b00000000,
	0b11011111,
	0b00000000,
	0b11110111,
	0b00000000,
	0b11101111,
	0b00000000,
	0b00000000,
	0b11011111,
	0b00000000,
	0b01111011
};


int winMessage[8][66] = { 
	{0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,1},
	{0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1},
	{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1},
	{0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
	{0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,1},
	{0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1},
	{0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
};
uint8_t pos = 0b00010000;
unsigned char game = 0x00;
unsigned char won = 0x00;
long i = 0;
long b = 0;
long start = 0;
volatile unsigned char TimerFlag = 0;
unsigned long _avr_timer_M = 1;
unsigned long _avr_timer_cntcurr = 0;

void TimerOn() {
	TCCR1B = 0x0B;
	OCR1A = 125;	
	TIMSK1 = 0x02; 
	TCNT1=0;
	_avr_timer_cntcurr = _avr_timer_M;
	SREG |= 0x80; 
}
void TimerOff() {
	TCCR1B = 0x00; 
}
void TimerISR() {
	TimerFlag = 1;
}
ISR(TIMER1_COMPA_vect) {
	_avr_timer_cntcurr--; 
	if (_avr_timer_cntcurr == 0) { 
		TimerISR(); 
		_avr_timer_cntcurr = _avr_timer_M;
	}
}
void TimerSet(unsigned long M) {
	_avr_timer_M = M;
	_avr_timer_cntcurr = _avr_timer_M;
}
void ADC_init() {
	ADCSRA |= (1 << ADEN) | (1 << ADSC) | (1 << ADATE);
}
int ADC_Read(char channel)
{
	int ADC_value;
	
	ADMUX = (0x40) | (channel & 0x03);
	ADCSRA |= (1<<ADSC);
	while((ADCSRA &(1<<ADIF))== 0);	
	
	ADCSRA |= (1<<ADIF);
	ADC_value = (int)ADCL;
	ADC_value = ADC_value + (int)ADCH*256;

	return ADC_value;
}

void joystick_Tick() {
	unsigned short in = ADC_Read(1);
	switch(j_state){
		case init:
			j_state = wait;
			break;
		case wait:
			if (won == 0x01) {
				j_state = gameOver;
			} else if (in > 700 || in < 300) {
				j_state = act;
			} else if (game == 0x01) {
				j_state = gameOver;
			} else {
				j_state = wait;
			}
			break;
		case act:
			j_state = waitOff;
			break;
		case waitOff:
			if (in > 300 && in < 700 ) {
				j_state = wait;
			} else if (game == 0x01) {
				j_state = gameOver;
			} else {
				j_state = waitOff;
			}
			break;
		case gameOver:
			break;
	}
	switch(j_state){
		case init:
			break;
		case wait:
			break;
		case act:
			if (in > 700 && pos != 0x80) {
				pos = pos << 1;
			} else if (in < 300 && pos != 0x01) {
				pos = pos >> 1;
			}
			break;
		case waitOff:
			break;
		case gameOver:
			break;
}
	if (game != 0x01 && won != 0x01) {
		ledmatrix7219d88_setrow(0, 7, game[(i)%118] | pos);
	}
}

void matrix_Tick() {
	switch(m_state){
		case normal:
			if (won == 0x01){
				m_state = finish;
			}
			i++;
			if (game[(i)%118] == (game[(i)%118] | pos) || game  == 0x01) {
				game = 0x01;
				m_state = over;
			}
			break;
		case over:
			if (won == 0x01){
				m_state = finish;
			} else {
				m_state = over;
			}
			break;
		case finish:
			break;
	}
	switch(m_state){
		case normal:
			ledmatrix7219d88_resetmatrix(0);
			ledmatrix7219d88_setrow(0, 0, game[(i+7)%118]);
			ledmatrix7219d88_setrow(0, 1, game[(i+6)%118]);
			ledmatrix7219d88_setrow(0, 2, game[(i+5)%118]);
			ledmatrix7219d88_setrow(0, 3, game[(i+4)%118]);
			ledmatrix7219d88_setrow(0, 4, game[(i+3)%118]);
			ledmatrix7219d88_setrow(0, 5, game[(i+2)%118]);
			ledmatrix7219d88_setrow(0, 6, game[(i+1)%118]);
			ledmatrix7219d88_setrow(0, 7, game[(i)%118] | pos);
			break;
		case over:
			if (b) {
				ledmatrix7219d88_resetmatrix(0);
				ledmatrix7219d88_setrow(0, 0, game[(i+7)%118]);
				ledmatrix7219d88_setrow(0, 1, game[(i+6)%118]);
				ledmatrix7219d88_setrow(0, 2, game[(i+5)%118]);
				ledmatrix7219d88_setrow(0, 3, game[(i+4)%118]);
				ledmatrix7219d88_setrow(0, 4, game[(i+3)%118]);
				ledmatrix7219d88_setrow(0, 5, game[(i+2)%118]);
				ledmatrix7219d88_setrow(0, 6, game[(i+1)%118]);
				ledmatrix7219d88_setrow(0, 7, game[(i)%118] | pos);
			} else {
				ledmatrix7219d88_resetmatrix(0);
				ledmatrix7219d88_setrow(0, 7, pos);
			}
			break;
		case finish:
			ledmatrix7219d88_resetmatrix(0);
			long j = 0;
			long k = 0;
			for (j = 0; j < 8; j++) { 
				for (k = 0; k < 8; k++) {
					if (winMessage[j][(k+start)%66]) {
						ledmatrix7219d88_setledon(0, (8*j)+k);
					} else {
						ledmatrix7219d88_setledoff(0, (8*j)+k);
					}
				}
			}
			start++;
	}
}

void reset() {
	switch(r_state){
		case wait1:
			if (~PINC & 0x01) {
				r_state = rst;
			} else {
				r_state = wait1;
			}
			break;
		case rst:
			r_state = wait2;
			break;
		case wait2:
			if (PINC & 0x01) {
				r_state = wait1;
			} else {
				r_state = wait2;
			}
			break;
	}
	switch(r_state){
		case wait1:
			break;
		case rst:
			i = 0;
			game = 0x00;
			won = 0x00;
			pos = 0b00010000;
			j_state = init;
			m_state = normal;
			joystick_Tick();
			matrix_Tick();
			break;
		case wait2:
			break;
	}
}

int main(void) {
	DDRA = 0x00; PORTA = 0xFF;
	DDRB = 0xFF; PORTB = 0x00;
	DDRC = 0x00; PORTC = 0xFF;
	DDRD = 0xFF; PORTD = 0x00;
	
	ledmatrix7219d88_init();
	ADC_init();
	
	unsigned long joystick_elapsedTime = 0;
	unsigned long matrix_elapsedTime = 0;
	unsigned long checkPos_elapsedTime = 0;
	unsigned long matrixTTime = 100 - (100*floor(i/118));
	const unsigned long timerPeriod = 10;
	TimerSet(timerPeriod);
	TimerOn();
	
	while(1){
		if (floor(i/118) > 0) {
			won = 0x01;
		}
		if (won == 0x01){
			matrixTTime = 50;
		} else {
			matrixTTime = 100 - (400*floor(i/118));
		}
		PORTB = 0x0F << (int)floor(i/118);
		
		if (joystick_elapsedTime >= 1) {
			reset();
			joystick_Tick();
			joystick_elapsedTime = 0;
		}
		
		if (matrix_elapsedTime >= matrixTTime) {
			matrix_Tick();
			if (b) {
				b = 0;
			} else {
				b = 1;
			}
			matrix_elapsedTime = 0;
		}
		if (checkPos_elapsedTime >= 100 && game == 0x00) {
			if (game[(i)%118] == (game[(i)%118] | pos)) {
				game = 0x01;
				matrix_Tick(b);
			}
			checkPos_elapsedTime = 0;
		}
		
		while (!TimerFlag) {}
		TimerFlag = 0;
		
		joystick_elapsedTime += timerPeriod;
		matrix_elapsedTime += timerPeriod;
		checkPos_elapsedTime += timerPeriod;
	}
}
