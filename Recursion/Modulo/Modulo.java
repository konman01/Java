package com.konman01.recursion;

public class Modulo {
	
	public int findModulo(int dividend, int divisor) {
		
		// divisor is Zero
		if(divisor == 0) {
			// means the return val is infinity
			return -1;
		}
		
		// if dividend if less than the divisor, then return dividend, Base Case
		if(dividend < divisor) {
			return dividend;
		}
		

		return findModulo(dividend - divisor, divisor);
		
	}// end of function

}// end of class

// Test Cases
// 1. If the dividend is less than the divisor
// 2. if the divisor is less than the Dividend
// 3. if divisor is 0 -- it will be infinity
// 4. if dividend is Zero
