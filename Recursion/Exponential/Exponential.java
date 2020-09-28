package com.konman01.recursion;

public class Exponential {
	
	// Calculate the Recursion using the Iterative Method
	public int calExponentIteration(int base, int exp) {
		
		int result = 1;
		
		for(int i = 0; i<exp; i++) {
			
			result = result * base;
		}
		
		return result;
		
	}// end of function
	
	// Function to calculate the Exponential Recursively
	public int calExponentRecursive(int base, int exp) {
		
		
		// 1. Base case
		
		// if the exp is 0, then return 1
		if(exp == 0) {
			return 1;
		}
		
		// recursive case 
		return base * (calExponentRecursive(base, exp - 1));
		
		
	}// end of function
	
	
}// End of exponential

// Test Cases:
// 1. if exp is 1
// 2. if exp is 0
// 3. if exp > 1

