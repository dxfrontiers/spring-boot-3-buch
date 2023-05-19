package de.springboot3.extending.library.conditional;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(
        value = "client.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class ConditionalAutoConfiguration {

    @Bean
    public Client conditionalAutoConfiguredClient() {
        return new Client();
    }

}
