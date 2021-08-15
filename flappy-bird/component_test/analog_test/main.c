






#include <avr/io.h>
#include <avr/interrupt.h>
#include "ADC_H.h"

/*

enum states{init, user_input} state;

void tick() {
  switch(state) { //transitions
    case init:
      state = user_input;
      break;
    case user_input:
      if(PA0 == 0 && PA1 == 0) { //in middle
        PORTB = 1;
				state = user_input;
      }
      else if(PA0 > 0) { //went right
        PORTB = 8; 
				state = user_input;
      }
      else if(PA0 < 0) { //went left
        PORTB = 16;
				state = user_input;
      }
      else if(PA1 > 0) { //went up
          PORTB = 2;
					state = user_input;
      }
      else if(PA1 < 0) { //went down
          PORTB = 4;
					state = user_input;
      }
		default:
			state = init;
			break;
  }

	switch (state) { //actions
		case init:
			break;
		case user_input:
			break;
		default:
			break;
	}


	}
}
*/

int main() {
  DDRA = 0xFF; PORTA = 0x00;
	DDRB = 0xFF; PORTB = 0x00;
  DDRC = 0xFF; PORTC = 0x00;
	DDRD = 0xFF; PORTD = 0x00;

	int x, y, xy, t;
	int x2, y2, xy2, t2;
	unsigned char center, up, down, left, right = 0;
	ADC_Init();

	while(1) {
		x = ADC_Read(0);
		y = ADC_Read(1);
		xy = ADC_Read(2);
		x2 = ADC_Read(3);
		y2 = ADC_Read(4);
		xy2 = ADC_Read(5);


	if(y>600) { //upward
			up = 1;
			PORTB = 16;
	}
	else if(y<400) {//down
		down = 1;
		PORTB = 2;
	}		
	else if(x<400) {//right
		right = 1;
		PORTB = 8;
	}	
	else if(x>600) {//left
		left = 1;
		PORTB = 4;
	}	
	else { //middle
		center = 1;
		PORTB = 1;
	}
	

	if(y2>600) { //upward
			up = 1;
			PORTD = 16;
	}
	else if(y2<400) {//down
		down = 1;
		PORTD = 2;
	}		
	else if(x2<400) {//right
		right = 1;
		PORTD = 8;
	}	
	else if(x2>600) {//left
		left = 1;
		PORTD = 4;
	}	
	else { //middle
		center = 1;
		PORTD = 1;
	}
	center = up = down = left = right = 0;

	}
	

}








/*
		if((x > 400 && x < 600) && (y > 400 && y < 600)) { //middle location
			center = 1;
			PORTB = 1;
			down = left = right = up = 0;
		}
		else {
			center = 0;
			PORTB = 0;
		}
//------------------------------------------------------------------------------

		if(y>600) { //upward
			up = 1;
			PORTB = 2
		}
		else {
			up = 0;
			PORTB = 1;
		}
//------------------------------------------------------------------------------

		if(y<400) {//down
			down = 1;
			PORTB = 16;
		}		
		else {
			down = 0;
			PORTB = 1;
		}

//------------------------------------------------------------------------------

		if(x<400) {//right
			right = 1;
			PORTB = 
		}
		else {
			right = 0;
			PORTB = 1;
		}

//------------------------------------------------------------------------------

		if(x>600) {//left
			left = 1;
			PORTB = ;
		}
		else {
			left = 0;
			PORTB = 1;
		}

*/
//=================================================================================

