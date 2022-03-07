package com.konman01.oops;

class Demo{
	
	public void execute() {
		System.out.println("Executing function in Demo");
	}
	
	public void run() {
		System.out.println("Executing run function in Demo");
	}
	
}

class Sample extends Demo
{
	public void execute() {
		System.out.println("Executing function in Sample");
	}
}


public class MethodOverriding {
	
	public static void main(String[] args) {
		
		// Creating Object Sample
		Sample sample = new Sample();
		sample.execute();
		sample.run();
		
	}

}
