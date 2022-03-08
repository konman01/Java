package com.konman01.oops;

class Demo1{
	
	public void execute() {
		System.out.println("Executing the execute function at Demo class");
	}
}

class Sample1 extends Demo1{
	
	public void run() {
		System.out.println("Executing the run function in Sample class");
	}
}




public class ClassCasting {
	
	public static void main(String[] args) {
		
		// Creating object of class Sample1
		Sample1 sample1 = new Sample1();
		sample1.execute();
		sample1.run();
		
		System.out.println("----------------------------------------");
		
		// Upcasting Sample Object to Demo
		Demo1 demo1 = sample1;
		
		
		
		demo1.execute();
		//demo1.run(); ther will be no run function on Demo as sample1 object is casted to Demo and run function is not defined in the Demo1 class
		
		System.out.println("----------------------------------------");
		
		// Downcasting demo1 to Sample1
		Sample1 sample2 = (Sample1) demo1; 
		
		sample2.execute();
		sample2.run();
		
		System.out.println("----------------------------------------");
		
	}

}
