package de.springboot3.java.explicit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class JavaConfigMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(GreetingConfiguration.class);

        GreetingService greetingService = applicationContext.getBean(GreetingService.class);
        System.out.println(greetingService.greet(1));
    }
}