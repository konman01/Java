package com.konman01.recursion;

public class Subset {
	
	public void getSubset(String soFar, String rest) {
		
		// if the rest is equal to "", there is no combination to make
		if(rest.equals("")) {
			
			// So print the Substring
			System.out.println(soFar);
			return;
		}else {
			
			// consider the first element of rest to make the combination
			getSubset(soFar + rest.charAt(0), rest.substring(1));
			
			// Do not consider the first element to make the combination
			getSubset(soFar, rest.substring(1));
		}
		
		
		return;
	}
	
	public void printSubset(String val_par) {
		
		getSubset("", val_par);
		
	}

}


