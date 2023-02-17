package de.springboot3.java.explicit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GreetingConfiguration {

    @Bean
    UserDatabase userDatabase() {
        return new UserDatabase();
    }

    @Bean
    GreetingService greetingService(UserDatabase userDatabase) {
        return new GreetingService(userDatabase);
    }

}
