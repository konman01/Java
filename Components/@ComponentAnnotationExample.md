### Application Contect 

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- Component Scanning -->
	<context:component-scan base-package="com.luv2code.springdemo"></context:component-scan>
    
    
</beans>
```

### Coach Interface and TennisCoach Implementation class

```
package com.luv2code.springdemo;

public interface Coach {
	
	String getDailyWorkout();

}

```

```
package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component // Default Bean Name wil be class name starting with small letter
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice you BackEnd Volly";
	}

}


```

### Main Class

```

package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// Read the Spring Config File
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the Bean from Bean Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call method on the Bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Close the Context
		context.close();

	}

}


```
