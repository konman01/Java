package com.konman01.oops;

class DemoClassCasting2{
	
	public void wish() {
		System.out.println("Hello");
	}
}

class SamplClassCasting2 extends DemoClassCasting2{
	public void wish() {
		System.out.println("Bye");
	}
}

public class ClassCasting2 {
	public static void main(String[] args) {
		
		SamplClassCasting2 sample1 = new SamplClassCasting2();
		sample1.wish();// Bye
		
		System.out.println("--------------------------------------");
		
		DemoClassCasting2 demo2 = sample1;
		sample1.wish();// Bye, Not hello
		
	}
}
