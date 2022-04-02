### Coach Interface and TrackCoach Implementation class

```
package com.luv2code.springdemo;

public interface Coach {
	
	String getDailyWorkout();
	
	String getDailyFortune();

}

```
```

package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		System.out.println("TrackCoach: Inside the constructor");
		fortuneService = theFortuneService;
	}
	
	public TrackCoach() {	
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run Hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("Doing my Startup stuff after the bean is instantiated");
	}
	
	public void doMyDestroyStuff() {
		System.out.println("Calling my Destroy method while destroying my bean");
	}

}

```

### Application Context File

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
    
    
    <context:property-placeholder location="classpath:sport.properties"/>

    <!-- Define your beans here -->
    <bean id = "myFortune"
    class = "com.luv2code.springdemo.HappyFortuneService">
    </bean>
    
    <!-- Constructor Injection -->
    <!-- myFortune bean will be created on line 11 and passed as argument to the constructor of class Coach to inject dependency -->
    <bean id="myCoach"
    class="com.luv2code.springdemo.TrackCoach"
    init-method="doMyStartupStuff"
    destroy-method="doMyDestroyStuff">
    
    	<constructor-arg ref="myFortune"></constructor-arg>
    </bean>
    
</beans>

```

### Main App

```
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Load the config class
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWorkout());
		
		
		context.close();

	}

}


```
