package com.konman01.recursion;

public class PrimeNumber {
	
	// Check if the given number is Prime
	public boolean checkPrimeIteratively(int num) {
		
		// num is less than or equal to 0
		if(num <= 0) {
		
			// return false
			return false;
		}
		
		
		int i = 2;
		
		// until the i is less than num
		while(i < num) {
			
			// num is divided by i
			if(num % i == 0) {
				
				// then return false
				return false;
			}
			i++;
			
		}

		// its a prime number
		return true;
		
	}// end of function
	
	
	
	public boolean isPrime(int val, int i) {
		
		// if the val is less than or equal to 1
		if(i <= 1) {
			// then its a prime
			return true;
		}
		
		// if val is divided by i 
		if(val % i == 0) {
			// then its not a prime
			return false;
		}
		
		// send val and i - 1
		return isPrime(val, i-1);
		 
	}// end of fucntion
	
	// function to check whether a number is prime
	public boolean checkPrimeRecursive(int num) {
		
		return isPrime(num, num -1);
		
	}// end of function

}
