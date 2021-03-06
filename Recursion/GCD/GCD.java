package com.konman01.recursion;

public class GCD {
	
	// Function to get the GCD of 2 numbers iteratively
	public int getGCDIterative(int val1, int val2) {
		
		// if val1 or val2 is zero
		if(val1 == 0 || val2 == 0) {
			// then return 0
			return 0;
		}
		
		int val = 1;
		int gcd = 1;
		
		// untill val is greater than val1 and val2
		while( (val1 > val) && (val2 > val) ) {
			
			// if the val1 and val2 are divided by val
			if((val1 % val == 0) && (val2 % val == 0)) {
				// then set the val to GCD
				gcd = val;
			}
			val++;
		}// end of while loop
		
		
		// return valx
		return gcd;
	}
	
	// Recursive Function to get the GCD of 2 numbers
	public int getGCDRecursive(int num1, int num2) {
		
		// if num1 == num2
		if(num1 == num2) {
			
			// then return num1, which is GCD
			return num1;
		}
		
		// if num1 > num2
		if(num1 > num2) {
			
			// subtract num1 by num2, and get the GCD
			return getGCDRecursive(num1 - num2, num2);
		}
		
		// else subtract num2 by num1 and get the GCD
		return getGCDRecursive(num1, num2-num1);
		
		
	}// end of function

}
