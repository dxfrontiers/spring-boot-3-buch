package de.springboot3.extending.library.beanpostprocessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ClientBeanPostProcessorConfiguration {

    private final ConfigurableApplicationContext context;

    public ClientBeanPostProcessorConfiguration(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Bean("beanPostProcessorExampleClient")
    public Client client(@Value("${client.baseUrl}") String baseUrl) {
        return new Client(baseUrl);
    }

}
