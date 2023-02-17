package de.springboot3.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class XmlConfigMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");

        GreetingService greetingService = applicationContext.getBean(GreetingService.class);
        System.out.println(greetingService.greet(1));
    }
}