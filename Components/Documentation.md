### What are Java Components?
Java componenets mainly consists of JDK(Java Development Kit), JRE(Java Runtime Environment) and JVM(Java Virtual Machine). 

JVM provides the runtime environment to run Java application. JVM converts java bycode to machine code. JVM is an instance of JRE. You cannot saperatly download the JVM. To use the JVM you have to download JRE.

JRE is set of software which is used provide runtime environment for Java Application. JVM uses these software during runtime. JRE is implementation of JVM. 

JDK is software development environment which is used to develop Java application. JDK contains JRE + development tools. JDK is implementation of Java platforms released by Oracle such as Standard Edition Java Platform, Enterprise Edition Java platform and Micro Edition Java Platform. 

### What are the differences between Abstract Class and Interface?
|Abstract Class|Interface|
|--------------|---------|
| Methods in the Abstract class can be a method having the implmentation or Abstarct Method | All the methods defined in an Interface are Abstarct Method |
| We can define the access specifier for the methods in the Abstarct class as default, protected or public | All the methods in an Interface is public |
|Abstarct class does not support multiple Inheritance | Interface can extends multiple interfaces |
| Abstract classes will have Constructors | Interfaces does not have Constructors |
| The data members can have any access specifiers | The data members in a class by default static final and public.|

### Why multiple inheritance is not supported in Java?

Every class in Java by default inherits Object class. If a class inherits 2 classes, then the object class properties will be inherited twice which cause ambuiguity at child class, And also we will be able to use only one super() statement in Java for constructor binding, so multiple inheritance is not possible.

### What are Object class methods?

Every class in Java by default inherits Object class. Object class consists for functions such as equals(), finalize(), hashcode() and toString() functions. These functions are allowed to get overrided in subclasses. Object class also contains thread functionality specific functions such as notify(), notifyAll() and wait(). These functions as not allowed to get overrided in subclass. 

equals() methods by default compares the memry address of 2 objects. In classed sunch as String, StringBuilder etc, the equal() method of Object class is overridden to compare the String value. 

hashcode() method by default provided the memory address in hexadecimal format. By definition, if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are equated and Object's implementation of hashCode() is no longer valid. Therefore, if you override the equals() method, you must also override the hashCode() method as well.

finalize() method is called by the garbage collector when it determines no more references to the object exist.the Object finalize method performs no actions but it may be overridden by any class, normally it should be overridden to clean-up non-Java resources ie closing a file etc. 

default toString() method provides memory address of the object. This method can be overrided in the sublass to get the String representation of object.

### What are Generics?

 Generics are used to define the type of object we can store in a collection. Before Java 1.5, we were able to store data of any types in Collection.
 
### What are the difference between Final, Finally and finalize()?

|Final|Finally|Finalize|
|-----|-------|--------|
| we use final keyword along with the literals or function members of a class. If a data member is declared as final, then it cannot be ovverided. If a function is declared as final, then the function defination cannot be overrided in sublass | Finally block is used to execute a set of statement after executing the try catch block. It is used to close heavy resourses such as files, DB connection ett if exception is thrown or not in an application | finalize() is a method called by the garbage collector when it determines no more references to the object exist|


### Difference between ArrayList and LinkedList?

| ArrayList | LinkedList|
|-----------|-----------|
| ArrayList internally uses dynamic array to store elements | Linked List internally used double linked list to store elelents |
| Memory allocation for ArrayList is continuous | Memory Allocation for LinkedList is Random |
| Manipulation of ArrayList such as adding element in between the arraylist or removing the element inbetween the array list is slow, since the other elements are requited to be shifter after the manipulation | LinkedList manipulation is faster compared to ArrayList as it internally uses the linkedlist to manage data |
| ArrayList can act only as List as it provides implementation to only List Interface | LinkedList provides implementation to List as well as Queue interface, so it can be used as List and Queue |
| ArrayList is best for storing and accessing the data | LinkedList is best for manipulating the data |


### What are the difference between Comparator and Comparable?

### Whar are the difference between Vector and ArrayList?

### How to create thread in Java?
We can create threads in Java by 2 mettods, by inheriting the Thread class and overriding the run() method, and by implementing Ruunable interface and providing implementation for run() method. We want to inherit other class, then we have to use the Runnable interface since Java does not support multiple inheritance.


### What is Syncronization?

If there are multiple threads executing on same resource, then it might corrupt the resource. To aviod this we can define a block or function as syncronized so that only once thread will be allowed at a time. When a thread start to execute the Syncronised block, then the block will be locked for other threads and will be released once the tread completes its execution.

If syncronised ketword is used for a method or a block, then it will be locked and executed by only one thread. Only when the thread compltes its execution, then only other thread can execute it.

### What is the difference between class level lock and object level lock?

#### Object level lock

Object level locking is mechanism when you want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given instance of the class. This should always be done to make instance level data thread safe. This can be done as below :

```
public class DemoClass 
{ 
  public synchronized void demoMethod(){} 
} 
```
or 

```
public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (this) 
  { 
   //other thread safe code 
  } 
 } 
} 

```

or 

```
public class DemoClass 
{ 
  private final Object lock = new Object(); 
  public void demoMethod(){ 
  synchronized (lock) 
 { 
  //other thread safe code 
 } 
} 

```

#### Class level lock

Class level locking prevents multiple threads to enter in synchronized block in any of all available instances on runtime. This means if in runtime there are 100 instances of DemoClass, then only one thread will be able to execute demoMethod() in any one of instance at a time, and all other instances will be locked for other threads. This should always be done to make static data thread safe.

```
public class DemoClass 
{ 
  public synchronized static void demoMethod(){} 
} 

```
or 

```
public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (DemoClass.class) 
  { 
   //other thread safe code 
  } 
 } 
} 

```
or 

```
public class DemoClass 
{ 
 private final static Object lock = new Object(); 
 public void demoMethod(){ 
 synchronized (lock) 
  { 
   //other thread safe code 
  } 
 } 
}
```

### If a thread T1 enters a method m1 by obtaining the class level lock, does this mean another thread T2 cannot run a different method m2 by obtaining the object level lock?

Object level lock and Class level locks are different. In above case, T2 can run method m2 by obtaining object level lock. But if m2 is static synchronized, T2 can't invoke m2 method unless T1 release class level lock on method m1.


### How threads communicates?

Thread communicates using wait() and notify() functions. wait() function releases lock on the resource by a thread and transfer it into other thread. Once the other thread uses the resources it should call notify() or notifyall() function to notify the waiting thread to continue.

### What are Java8 features?

Lambda Expressions, Functional interface, default methods, functions, predicates and Stream Api




### What is Java Lambda Expression?

Lambda Expressions are like annonymous function or closure where we dont define function name, return type and access specifier. Lambda expression provides clear and concise way to represent method defination using expression. The Lambda expression is used to provide the implementation of an interface which has functional interface. It saves a lot of code. In case of lambda expression, we don't need to define the method again for providing the implementation. Here, we just write the implementation code.

Implementation of Functional Interface by Annonymous Class
```

package com.konman01.lambdatest;

// Functional Interface
interface Drawable {
	
	void draw();
	
}

// Without Using the Lamda Function
public class LambdaExpressionExample1 {
	
	public static void main(String[] args) {
		
		
		// Drawable implementation using Annonymous Class
		Drawable drawable = new Drawable() {
			
			@Override
			public void draw() {
				System.out.println("Drwaing by Manjunatha");
				
			}
		};
		
		drawable.draw();
		
		
	}

}
```
Implementation Using Lambda Expression(No Argument Function in Functional Interface)

```

package com.konman01.lambdatest;

interface Drawable1{
	
	void draw();
}

public class LambdaExpressionExample2 {
	
	public static void main(String[] args) {
		
		// Drawable1 is being implemented by Lamda Expression
		Drawable1 draw	= ()->{
			
			System.out.println("Drawing by Manjunatha!!");
			
		};
		
		draw.draw();
		
		
	}

}

```

Implementation Using Lambda Expression(Function interface having parameter)

```
package com.konman01.lambdatest;


interface Sayable{
	
	String say(String name);
}

public class LambdaExpressionExample3 {
	
	public static void main(String[] args) {
		
		// Implementation using Lamda Expression
		Sayable sayable = (name)->{
			
			return "Hello, "+name+"!, I have nothing to Say";
		};
		
		System.out.println(sayable.say("Manjunatha"));
		
		
	}

}

```




### What are Functional Interfaces?

An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class. Example for function interfaces are Runnable interface with run function, Comparable interface with compareTo() function

```

package com.konman01.functionalinterfacetest;

interface Hello{
	
	// Functional Interface Should contain only one Abstarct Method
	String sayHello(String name);
	
	
	// It can contain the functions from Object Class
    String toString();  
    boolean equals(Object obj);  
    
    // Can contain any number of Default Method 
    default void greet() {
    	System.out.println("Hello Everyone");
    }
    
    default void wish() {
    	System.out.println("Have wonderful day!!!");
    }
    
    // can contain any number od Static Methods
    static void bye() {
    	System.out.println("Bye, Bye!!!!!");
    }
    
    static void goodNight() {
    	System.out.println("Good Night!!!");
    }
	
}

public class FunctionInterfaceExample1 {
	
	
	public static void main(String[] args) {
		
		Hello hello = (String name)->{
			return "Hello,"+name;
		};
		
		System.out.println(hello);
		
		System.out.println(hello.sayHello("Manjunatha"));
		
		hello.greet();
	}

}


```

### What is Predicate?

Predicate is a Functional Interface. It conatins a function by name test(), which as one argument and returns the boolean value. 

```
package com.konman01.predicatesTest;
import java.util.function.Predicate;


public class PredicateExample1 {
	
	public static void main(String[] args) {
		
		// Predicate to Test if the number is greater than 20
		Predicate<Integer> predicate = (i)->{
			return i > 20;
		};
		
		// Predicate to check if the length of the String is greater than 5 Chracter
		Predicate<String> predicateStr = (str)->{
			return str.length() > 5;
		};
		
		System.out.println(predicate.test(25));// true
		
		System.out.println(predicate.test(-1));// false
		
		System.out.println(predicateStr.test("Manjunatha"));// true
		
	}

}
```

### What are predicate Joins?

Predicate join allows us to use more than one Predicate together, or to negate the result of predicate. 

```
package com.konman01.predicatesTest;
import java.util.Iterator;
import java.util.function.Predicate;

public class PredicateJoinExample1 {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 13, 4, 6, 8, 2, 1, -1, 0};
		
		Predicate<Integer> greaterThan10Predicate = i->i > 10;
		Predicate<Integer> evenPredicate = i-> i % 2==0;
		
		method(greaterThan10Predicate, arr);
		
		method(evenPredicate, arr);
		
		method(greaterThan10Predicate.negate(), arr);
		
		method(evenPredicate.or(greaterThan10Predicate), arr);
		
		method(evenPredicate.and(greaterThan10Predicate), arr);
		
	}
	
	public static void method(Predicate<Integer> predicate, int[] arr) {
		
		for (int val: arr) {
			System.out.println("val:"+val);
			System.out.println("result:"+predicate.test(val));
		}
		
		System.out.println("----------------------------------------");
		
		return;
	}

}

```
