package de.springboot3.troubleshooting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("service.active.enabled")
public class MyServiceConfiguration {

    @Bean
    public MyService myService() {
        return new MyService();
    }

}

