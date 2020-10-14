package com.konman01.recursion;

public class Fibonacci {
	
	// Function to calculate the fibonacci recursively
	public int fiboRecursive(int n) {
		
		
		if(n <= 1) {
			return n;
		}
		
		return fiboRecursive(n-1) + fiboRecursive(n-2);
		
		
	}// end of function
	
	
	// Function to calculate the Fibonacci Iteratively
	public int fiboIterative(int n) {
		
		// if the val is less than or equal to 1
		if(n <= 1) {
			
			// return 1
			return 1;
		}
		
		// set the 2 values to 1
		int val1 = 1;
		int val2 = 1;
		int result = 0;
		
		for(int i= 3; i<=n; i++) {
			
			// add 2 values to result
			result = val1 + val2;
			
			// transfer val 1 to val 2
			// and result to val1
			val2 = val1;
			val1 = result;
			
		}// end of for loop
		
		return result;
		
	}// end of function
	
	

}// end of class
