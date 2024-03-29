### What is Spring Container

Spring container is the core of Spring Framwork. It creates and manage complete lifecycle of an Object (Invertion Control) and injects objects dependencies(Dependency Injection). The container gets its instructions on what objects to instantiate, configure, and assemble by reading the configuration metadata provided. The configuration metadata can be represented either by XML, Java annotations, or Java code. 

### What is spring Bean?

When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".

### What is Inversion Control

It is an approch of outsourcing the construction and management of objects. Here, the client will not create required object manually, instead he delegates the responsibility to Spring container to create and manage an Object.

### What is Dependency Injection?

Dependency Injection in a practice where we create objects saperately and injects its dependency during runtime instead of constructing them internally. 

For example we have a Coach Class and for the Coach class we have defined CoachDetail classtype variable. The Spring container creates the object of the CoachDetail class first then creates the object of Coach class by injecting the reference of CoachDetail Object during runtime. 

The Dependency Injection can be performed by 2 ways, constructor injection and Setter Injection. We inject dependency at constructor level in constructor injection. We use setter function to inject dependency in Setter Injection

Spring container creates only one intance of bean by default and It will be cached in memory and being shared by all the request.We can define the scope to tell spring container how to create Bean. By default the scope will be Singletone, ie only once instance of the bean will be created. If the Scope is Prototype then spring container will create new instance of bean for each request. 

### explain Bean life Cycle

First Spring Container instantiate the Bean, then dependencies will be injected and next there will some internal processing in Spring Container. Then there will be option to call some initialization code. After that bean will be available to use. When the containers or application is shutdown, there will be option to call custom destroy method before deleting the bean. 

During the Bean initialization, you can add custom code based on your business logic or setting ups some resources like db etc. You can also add code during bean destruction to do some operation bases on your bussiness logic. 

For "prototype" scoped beans, Spring does not call the destroy method.  In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding. This also applies to both XML configuration and Annotation-based configuration.

### What are Java Annotation?

Java Annotations are special Markers or lables to Java classes. It provides meta data about the classes. 

#### @Component Annotation

We will define Component-Scan Attribute with the base package name in Application Context file. Spring refers to all classes defined under the base package defined in the Component-Scan attribute. Whereever @Component Annotation is mentioned, Bean will be created by the spring container. 




