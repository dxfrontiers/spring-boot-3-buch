package de.springboot3.troubleshooting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "foo", matchIfMissing = true)
public class MyActiveConfiguration {

    @Bean
    public MyService myService() {
        return new MyService();
    }

}

