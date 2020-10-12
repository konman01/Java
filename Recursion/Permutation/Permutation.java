package com.konman01.recursion;

public class Permutation {
	
	
	private void listPermutation(String str1, String str2) {
		
		// if thr str1 length is 0, then there is no character left to form the permutation
		if(str1.length() == 0) {
			
			// Just print the Str2 and return
			System.out.println(str2);
			return;
		}
		
		
		
		for(int i = 0; i<str1.length(); i++) {

			// concatenate the String 
			
			// Add one charatcer from string 1 to string 2
			String strVal2 = str2+str1.charAt(i);
			 
			// get the remaining characters in Str1
			String strVal1 = str1.substring(0, i) + str1.substring(i+1);
			 
			// recurse
			listPermutation(strVal1, strVal2);
			
		}
		
		return;
	}
	
	public void printPermuation(String val) {
		
		// if the string is null || length is 0
		if(val == null || val.length() == 0) {
			
			// return
			return;
		}
		
		// list all the permutation posible for the String
		listPermutation(val, "");
		
		
		return;
	}

}
