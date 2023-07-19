package de.springboot3.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBasicsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicsApplication.class, args);
    }

    @Bean
    public HelloBean helloBean() {
        return new HelloBean();
    }

    static class HelloBean {
        public HelloBean() {
            System.out.println("Hello!");
        }
    }
}