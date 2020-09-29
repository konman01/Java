package com.konman01.recursion;

public class Palindrome {
	
	// Function to check whether the given string is palindrome by iterative methopd
	public boolean isPlaindromeIterative(String str) {
		
		// if the string length <= 1, then its palindrome
		if(str.length() <= 1) {
			return true;
		}
		
		// get the first index and last index of the string
		int start = 0, end = str.length() - 1;
		
		while(start < end) {
			
			// if the char at the index start is not equal to char at index end
			if(str.charAt(start) != str.charAt(end)) {
				
				// its not palindrome
				return false;
			}
			
			start++;
			end--;
			
			
		}// end of while loop
		
		// all the characters in the string is checked, so its palindrom
		return true;
		
	}// end of function
	
	
	public boolean isPalindromeRecursive(String str) {
		
		// if the length of the string is less than or equal to 1
		if(str.length() <= 1) {
			
			// the string is palindrome
			return true;
		}
		
		return (str.charAt(0) == str.charAt(str.length() - 1)) 
				&& isPalindromeRecursive(str.substring(1, str.length() -2));
	}
	

}// end of class

// Test cases
// 1. String with 0 character
// 2. String with 1 character
// 3. String with n characters

