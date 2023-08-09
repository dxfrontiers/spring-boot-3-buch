package de.springboot3.configuration.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public HelloBean helloBean(@Value("${custom.app-name}") String appName) {
        return new HelloBean(appName);
    }

    static class HelloBean {
        public HelloBean(String appName) {
            System.out.println(String.format("Hello from \"%s\"!", appName));
        }
    }

}
