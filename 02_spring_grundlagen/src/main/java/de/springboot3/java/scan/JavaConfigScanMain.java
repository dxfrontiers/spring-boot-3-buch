package de.springboot3.java.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class JavaConfigScanMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("de.springboot3.java.scan");

        GreetingService greetingService = applicationContext.getBean(GreetingService.class);
        System.out.println(greetingService.greet(1));
    }
}