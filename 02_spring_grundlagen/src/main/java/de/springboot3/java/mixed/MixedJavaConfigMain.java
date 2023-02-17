package de.springboot3.java.mixed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MixedJavaConfigMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MixedConfiguration.class);

        GreetingService greetingService = applicationContext.getBean(GreetingService.class);
        System.out.println(greetingService.greet(1));
    }
}