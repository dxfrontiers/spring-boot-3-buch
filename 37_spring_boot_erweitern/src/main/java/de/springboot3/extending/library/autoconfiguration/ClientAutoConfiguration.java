package de.springboot3.extending.library.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ClientAutoConfiguration {

    @Bean
    public Client autoConfiguredClient() {
        return new Client();
    }

}
