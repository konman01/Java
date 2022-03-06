# OOPS Documentation

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
* The Constructor name should be same as class name, and should not have any return type
* Constructors of a class are never inherited and therefore are not subject to hiding or overriding. So constructors cannot be declared as Final
* When you set a member as static it means: "This method belongs to the class, not to a particular object." But the constructor is implicitly called to initialize an data members of a class(static members cannot use non static members), so we cannot declare constructors as Static members.
* When you set a method as abstract it means: "This method doesn't have a body and it should be implemented in a child class." But the constructor is called implicitly for instance initialization when the new keyword is used so it can't lack a body. So Constructors cannot be declated as Abstarct


#### Notes
* Default Constructors will be created by the compiler if and only if there are no user defined constructors in the class
* this keyword is used to refer the non static members of the current class. this keyword contains the memory address of the instance. 
* new operator communicate the address where instance is created to the constructor for initialization. The constructor initialises the instance and returns the address. This address should be kept in a reference variable in order to access the instance for future use.

## Composition and Inheritance
-------------------------------
* An object can build a relationship with another Object. The Relationship can be of 2 types. 1) Has a relationship, 2) Is a relationship
* Has a Relationship can be achieved by Composition, where as Is a relationship can be acieved by inheritance.

### Composition

If a reference variable of a class type is defined as datamember of a class, then we are aceiving Composition. The reference datamember can be static or Non Static. If the reference member is a static datamember, then it will loaded only once in the memory. If the reference member is a non static data member, then it will be loaded whenever the instance of the class is created.

### Inheritance

Inheritance is a mechanism where once class inherits the properties of another class. The class from where the properties are inherited is known as superclass or base class. The class which inherits another class is known as child class or subclass.

#### Points
* Subclass can inherit only non static members of a superclass or base class.
* Whenever we create instance of a subclass, we will always have properties of subclass and super class.
* Inheritace is used to achive generalization
* If a class is declared as Final, then it cannot have a subclass. A final class can be a subclass and we can create instance of final class.
* If a superclass have non static members having the access specifier as Private, then it cannot be inherited to subclass.
* Each and every class defined in Java language must have a superclass. If there is no superclass defined by the user, then the compiler define Object class as its super class. 


#### Notes
* Java provides extend keyword to inherit a class.








