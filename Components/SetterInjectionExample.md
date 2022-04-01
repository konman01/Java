### Properties File

```
foo.email=test@luuv2code.com
foo.team=royal challengers Banglore
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
    
    <!-- importing the sport.properties file -->
    <context:property-placeholder location="classpath:sport.properties"/>

    <!-- Define your beans here -->
    <bean id = "myFortune"
    class = "com.luv2code.springdemo.HappyFortuneService">
    </bean>
    
    <!-- Setter Injection -->
    <!--  name="fortuneService"  setFortuneService Setter Function will be called -->
    <!-- ref = "myFortune" service created in line 22 will be passsed as argument to the setter Function -->
    <bean id = "myCricketCoach"
    class = "com.luv2code.springdemo.CricketCoach">
    	<!-- Inject Ref -->
    	<property name="fortuneService" ref="myFortune"></property>
    	
    	<!-- Inject Literal Value -->
    	<property name="emailAddress" value="${foo.email}"></property>
    	<property name="team" value="${foo.team}"></property>
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

### Caoch Interface And Cricket Coach Implementation Class

```
package com.luv2code.springdemo;

public interface Coach {
	
	String getDailyWorkout();
	
	String getDailyFortune();

}
```

```
package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach:Inside the no Arg constructor");
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// This is the Setter Method called by Spring to inject dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach:Inside the Setter Method to Inject Fortune Service");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddressString) {
		System.out.println("CricketCoach:Inside the Setter Method to set Email Address");
		this.emailAddress = emailAddressString;
	}

	public void setTeam(String teamString) {
		System.out.println("CricketCoach:Inside the Setter Method to set Team");
		this.team = teamString;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Do 100 pushups";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
}

```

### Main Class

```
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Load the config class
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());
		
		context.close();

	}

}

```

### output

```
CricketCoach:Inside the no Arg constructor
CricketCoach:Inside the Setter Method to Inject Fortune Service
CricketCoach:Inside the Setter Method to set Email Address
CricketCoach:Inside the Setter Method to set Team
Today is your lucky Day
Do 100 pushups
test@luuv2code.com
royal challengers Banglore

```


