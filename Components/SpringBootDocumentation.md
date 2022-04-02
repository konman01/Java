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


