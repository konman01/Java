package com.konman01.recursion;

public class PermutationCount {
	
	
	public int countPermuation(int val) {
		
		// if the value is less than equal to 1, then return 1
		if(val <= 1) {
			return 1;
		}
		
		// else calculate the permutation for n - 1
		return val * countPermuation(val -1 );
		
	}// end of function

	
}// end of class

// val is 0
// val is 1
// val is > 1
// do not give value < 0
