package org.gontuseries.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringProject {
			public static void main(String[] args) {
			
			ApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
			Restaurant restaurantObj=(Restaurant) context.getBean("restaurantBean");
			restaurantObj.greetCustomer();
			}
			
}
