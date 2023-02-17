package de.springboot3.java.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.springboot3.java.mixed")
class MixedConfiguration {

    @Bean
    GreetingService greetingService(UserDatabase userDatabase) {
        // The UserDatabase bean will be automatically picked up by the @ComponentScan, since it's annotated
        // with @Component.
        return new GreetingService(userDatabase);
    }

}
