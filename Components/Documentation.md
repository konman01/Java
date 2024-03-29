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


| Comparable | Comparator |
|------------|------------|
| Comparable provides only one sorting sequence, means we can sort elements based on only one class literals such as Id, name or age | Comparator provides multiple sorting sequence, that is we can sort the objects using combination of multiple sequence |
| Comparable affects the actual class means on the class level we nedd to provide the implementation to Comparble Interface and override compareTo() method | Comparator does not modify the original class |
| Collection.sort() sort the list of objects of class which implements the compareTo() method | Collections.sort(list, Comparator) sort the elements |


Read more: https://javarevisited.blogspot.com/2011/12/final-variable-method-class-java.html#ixzz7ZMlnulzR

### Whar are the difference between Vector and ArrayList?



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


### What are default methods in interface?

Methods which are defined inside the interface and tagged with default are known as default methods. These methods are non-abstract methods.If we have an interface and that interface is being implemented by multiple classes, then all the classes should provide implementation for the abstarct methods in the interface. In future, If we add more abstract methods in the interface, then we need to modify all the implementation class to provide defination for abstarct method. We use the default methods in interface to provide default implementation for the abstact methods.

```
package com.konman01.defaultmethodtest;

interface Greet{
	// Defining Default Method
	default void sayHello() {
		System.out.println("Hello, good morning");
	}
	
	// Abstarct Method
	void sayBye();
}

// Implementation class
public class DefaultMethodExample1 implements Greet{

	// Providing the implementation to abstarct method
	@Override
	public void sayBye() {
		
		System.out.println("Bye!!!!");
		
	}
	
	// Main method
	public static void main(String[] args) {
		
		DefaultMethodExample1 obj = new DefaultMethodExample1();
		obj.sayBye();
		obj.sayHello();
		
	}
	
	
}// End of class

```

### Can we define static method in an Interface?

We can define static methods inside the interface. Static methods are used to define utility methods.

```

package com.konman01.interfacestatictest;

interface Wish{
	
	// Static method in interface
	static void Wish() {
		System.out.println("Have a great Day!!!");
	}
	
	// Abstract method in an Interface
	void bless();
	
}

public class InterfaceStaticMethod1 implements Wish{

	@Override
	public void bless() {
		System.out.println("God Bless You");
		
	}
	
	public static void main(String[] args) {
		
		// Calling Static Method from interface
		Wish.Wish();
		
	}

}

```

### Can a class implement 2 interfaces having same default method?

Yes, A class implement 2 interfaces having same method but the implementation class should override the default method.

```
package com.konman01.defaultmethodtest;

interface Test1{
	
	default void run() {
		System.out.println("Executing run in Test1!!!");
	}
}

interface Test2{
	
	default void run() {
		System.out.println("Executing run in Test2!!!");
	}
	
}

public class DefaultMethodExample2 implements Test1, Test2{

	@Override
	public void run() {
		System.out.println("Executing run in DefaultMethodExample2");
	}
	
	
	public static void main(String[] args) {
		DefaultMethodExample2 obj = new DefaultMethodExample2();
		obj.run();// Executing run in DefaultMethodExample2
	}

}

```

### Stream Util Package in Java

Java provides a new additional package in Java 8 called java.util.stream. This package consists of classes, interfaces and enum to allows functional-style operations on the elements. You can use stream by importing java.util.stream package.

Stream provides following features:

* Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
* Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
* Stream is lazy and evaluates code only when required.
* The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
