# OOPS Documentation

Object-Oriented Programming is a paradigm that provides many concepts, such as inheritance, data binding, polymorphism

## Class
-----------

| Class | Object |
|-------|--------|
|Class is a Defination block which defines states and behaviour of an object. The states are defined by using the data members where as behaviours are defined by function members | Any entity which shows its own states and behaviour is known as an Object. States represents the characteristics of an object. Behavious represents the fuctionalities that can be performed on the object.


## Static and Non static Members

| Static Members | Non static members|
|----------------|--------------------|
|Static members are referred by class name, hence static members are called as class members|Non Static members are refered by creating an instance of a class, hence non static members are called as instace members|
|Static members will be loaded only once in the memory| Non static members will be loaded any number of times based on the instance creation|


#### Notes
* Java provides new opearator to create an instance of a class. Whenever we create an instance of a class, a copy of non static members will be loaded into memory
* In Java, we can create 2 types of variables. Primitive variables and Reference variables. Primitive variables are declared using datatype. It is used to store data. Primitive variables does not support OOPs principles. Reference variables are declared using Class Names. Reference variable is used to store instance. It contains the memory address where the instance is stored.


## Constructors
-----------------
Constructors are members of the class used to initialize the datamembers of the class. Every class defined in the JAVA language will be having a constructor. There are 2 types of constructors, User defined Constructor or Default constructors

| Default Constructor | User Defined Constructor|
|---------------------|-------------------------|
| Constructors defined by the complier is known as Default Constructor| Constructors defined by the users are known as User Defined Constructors|
| Default Constructors will always be Zero Argument Constructor | User defined constructor can be Zero Argument constructor or paramaterialised constructor |


### Constructor Overloading
Defining multiple constructors in a class with different parameters is known as Constructor Overloading. The parameters should differ in parameter types or number of parameters passed. Constructor Overloading helpds to initialize the instance of a class in different way.               

#### Points
* The Constructor name should be same as the class name, and should not have any return type
* Constructors of a class are never inherited and therefore are not subject to hiding or overriding. So constructors cannot be declared as Abstarct
* The child class inherits all the members of the superclass except the constructors. In other words, constructors cannot be inherited in Java therefore you cannot override constructors. So, writing final before constructors makes no sense. Therefore, java does not allow final keyword before a constructor.
* When you set a member as static it means: "This method belongs to the class, not to a particular object." But a constructor is implicitly called to initialize  data members of a class(static blocks cannot use non static members), so we cannot declare constructors as Static members.
* When you set a method as abstract it means: "This method doesn't have a body and it should be implemented in a child class." But the constructor is called implicitly for instance initialization when the new keyword is used so it can't lack a body. So Constructors cannot be declared as Abstarct


#### Notes
* Default Constructors will be created by the compiler if and only if there are no user defined constructors in the class
* this keyword is used to refer the non static members of the current class. this keyword contains the memory address of the instance. 
* new operator communicate the address where instance is created to the constructor for initialization. The constructor initialises the instance and returns the address. This address should be kept in a reference variable in order to access the instance for future use.

## Composition and Inheritance
-------------------------------
* An object can build a relationship with another Object. The Relationship can be of 2 types. 1) Has a relationship, 2) Is a relationship
* Has a Relationship can be achieved by Composition, where as Is a relationship can be acieved by inheritance.

### Composition

If a reference variable of a class type is defined as datamember in a class, then we are aceiving Composition. The reference datamember can be static or Non Static. If the reference member is a static datamember, then it will loaded only once in the memory. If the reference member is a non static data member, then it will be loaded whenever an instance of the class is created.

### Inheritance

Inheritance is a mechanism where one class inherits the properties of another class. The class from where the properties are inherited is known as superclass or base class. The class which inherits another class is known as child class or subclass.

#### Points
* Subclass can inherit only non static members of a superclass or base class.
* Whenever we create instance of a subclass, we will always have properties of subclass and super class.
* Inheritace is used to achive generalization
* If a class is declared as Final, then it cannot have a subclass. A final class can be a subclass and we can create instance of final class.
* If a superclass have non static members having the access specifier as Private, then it cannot be inherited to subclass.
* Each and every class defined in Java language must have a superclass. If there is no superclass defined by the user, then the compiler define Object class as its super class. 

#### Notes
* Java provides extend keyword to inherit a class.

## this() statement

A constructor of a class can make call to another constructor in the same class using this() statement. this() statement can be used to call Zero Argument constructor or parameterialised constructor.

#### Points

* this statement should be used only inside a constructor and it should be the first statement in the constructor. There should be only one this() statement in a constructor.


## Constructor Chaining
-------------------------------

Whenever we create an instance of subclass, the subclass constructor should call to its supercall class constructor. The superclass constructor should call its super class constructor. This phenomenon is known as Constructor Chaining. The subclass constructor can make call to its superclass constructor using super() statement. 

#### Points

* The constructor chaining can be done either explicitly or implicitly. If the superclass has a Zero Argument constructor, the compiler itself will make call to its superclass constructor from subclass constructor if user has not defined it. If the superclass has only parameterialised constructor, then user should make explit call from  subclass constructor to superclass constructor using super() statement.
* super() statement should be first statement in a constructor and there should be only one super() statement in a constructor. In a constructor we can call either call super() statement or this() statement, we cannot call both.

#### Notes

Why multiple inheritance is not allowed? - If we inherit multiple classes to a subclass, then the object class properies will be inherited twice, this will cause the ambiguity at the subclass, And also we can use only one super() statement in a subclass. So we cannot inherit multiple class at the same time. 

## Method Overloading
-------------------------------

Definig multiple methods with same name and different parameters is known as Method overloading. The parameters should differ in parameter type or in terms of number of parameters defined for the method

#### Notes
* In a class we can overload static method or non static method.
* The overloading method can be performed either in the same class or we can define the method with same name with different parameter in super class and inherit to subclass. 
* The method overloading is used to achieve compile time polymorphism. Whenever overloaded methods are invoked for execution, it will be called based on the arguments. 


## Method Overriding
-------------------------------

Inheriting a method from superclass and changing its implementation in subclass according to subclass specification is known as Method Overriding. 

#### Notes
* To perform inheritance, method overriding is Mandatory.
* Method overriding is used to achieve run time polymorphism. 
* Subclass cannot override following methods.
  *   Static method. Static methods are specific to class and it is not inheritted. So static method cannot be overrided.
  *   private method - method having the private access specifier are specific to the class and it is not inheritted to subclass. So we cannot override the private methods.
  *   Final method - Final means we cannot override the value, so Final method cannot be inheritted.


## Class Casting
-------------------------------
Casting one class type to another class type is known as Class casting. Class casting can be achieve between two class having is a relationship. 

* The instance of the class which has to be casted to another class must have all the properties of that class. Otherwise compiler throws ClassCast Exception.
* class casting can boe done in 2 ways.
  * Upcasting
  * Downcasting
* Casting subclass instance to super class type is know as upcasting. Upcasting can be performed from any subclass level to superclass. Upcasting can be performed either implicitly(by compiler) or explicitly. 
* Casting superclass instance to subclass class type is known as downcasting. The downcasting should be performed explicity. Downcasting can be performed only on the instance which is already upcasted. 

#### Points
* If instance has overrided method, when we refer such instance with either superclass reference or subclass reference, we get overrided implementation. (Look for code ClassCasting2.java program).


## Polymorphism

Object showing different behaviours at different stages of it lifecycle is known as Polymorphism. There are two types of polymorphism, Compiletime polymorphism and Runtime polymorphism.

* In Compiletime polymorphism, teh method declaration is binded to its implementation at compile time. Since binding is hapenning at compile time, it is called as compiletime polymorphism. Compiletime polymorphism can be achieved by using method overloading. 
* In Runtime polymorphism, a method declaration is binded to its implementation at the runtime by JVM. Since binding happens at Runtime it is called as Runtime polymorphism. Runtime polymorphism can be achieved by using inheritance, method overriding and Type Casting

## Generalization

While developing a program , if we are referring a subclass instance by its superclass type, then we say the code is developed with generalization. The generalization helps us to achieve maintainable and enhanceable code.

## Abstract Class

Defining a method without a body is known as Abstact method. Abstact methods do not specify method body and it should be declared with abstract keyword. Abstact method should be developed in a abstact class. A class declared with abstact keyword is known as Abstact class.

#### Points
* You cannot make static metod as Abstact because static methods are specific to class and cannot be inherited to subclass for overriding. 
* An Abstact class can have concrete methods only, Abstact methods only or both.
* If a class is defined as Abstact it is not mandatory to have the abstact methods in the class, but any class having abstact must be declared as abstarct 
* When a class inherits an abstact class, the subclass should define the methods for all the inherited abstact methods. Otherwise the subclass should be as Abstact.
* We can not create instance of abstact class.


## Interface

Inteface is a pure abstact class body where we can define only abstact methods. Interface methods by default are abstact methods and they have public access. Interface variables by default are static, final and they will be having public access.  

The interface methods should be implemented by a class. A class which implements an interface is known as implementation class. A class can implements any number of abstact methods from the interface. If a class is not providing implementation to all the methods in an interface, then the implementation class should be declared as Abstact class. 

#### Points

* We cannot create instance of an interfaces
* By Interface, we can support functionality of Multiple inheritance.
* First of all Interfaces are used to specify common methods for a set of unrelated classes for which every class will have a unique implementation. Therefore it is not possible to specify the access modifier as private since it cannot be accessed by other classes to be overridden. Interface might be implemented (realized) by different unrelated classes which are not in the same package therefore protected access modifier is not valid as well.
* If method type is interface type, then to such method we can pass an instance of any implementation class of the interface. If the method return type is interface type, then such methods can return any instance of the implementation class of that interface.

## Abstraction

Hiding implementation from its utilization is known as Abstraction. To achieve abstaction we have to follow below steps.
 1. Generalize all the functionalities in an interface
 2. provide specific implmentation in an implementation class.
 3. Refer implementation class instances using the interface type


## Encalpsulation

Encapsulation is one of the OOPs principle which defines the acess level for the members of a class. We can define the restrictions on the class members by using access specifiers. 

#### Points

* Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
* Default(Package Level): The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
* Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
* Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

#### Points

* The default access of members of a class is Package level, where as default access level of members of interface are public.
* A constructor can have any of the 4 access. If the constructor is declared as private, then interface creation is restrivted to the clkass body, and we cannot create instance anywhere else. This is used to create Singletone class.
* The constrctor defined by the compiler will have the access same as that of the class. The user defined constructor can have any of the 4 access. 
* While overrding, subclass has 
* permission to change the access of the inherited method. The subclass should retain the same access level or it should increate the accesss level but cannot decreare the access level.
* When a class provides implementation to interface methods, that class should retain the public access otherwise the compiler throws exception











