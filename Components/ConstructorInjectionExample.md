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

    <!-- creating Bean of HappyFortuneService here with the name myFortune-->
    <bean id = "myFortune"
    class = "com.luv2code.springdemo.HappyFortuneService">
    </bean>
    
    <!-- Constructor Injection -->
    <!-- myFortune bean created created at line 14 will be passed as argument to the constructor of class Coach to inject dependency -->
    <bean id="myCoach"
    class="com.luv2code.springdemo.BaseBallCoach">
    	<constructor-arg ref="myFortune"></constructor-arg>
    </bean>
    
</beans>

```

### FortuneService Interface and HappyFortuneService Implementation class


```
package com.luv2code.springdemo;

public interface FortuneService {
	
	String getFortune();

}

```

```
package com.luv2code.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky Day";
	}

}

```

### Coach Interface and BaseBallCoach Implementation class

```
package com.luv2code.springdemo;

public interface Coach {
	
	String getDailyWorkout();
	
	String getDailyFortune();

}

```
```
package com.luv2code.springdemo;

public class BaseBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Run 2k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

```

### Main App

```
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
				

	}

}

```
