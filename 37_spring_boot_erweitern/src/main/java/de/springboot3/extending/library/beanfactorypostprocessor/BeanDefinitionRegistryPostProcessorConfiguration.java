package de.springboot3.extending.library.beanfactorypostprocessor;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
public class BeanDefinitionRegistryPostProcessorConfiguration {

    @Bean
    public BeanDefinitionRegistryPostProcessor clientRegistrar(Environment environment) {
        return new ClientRegistrar(environment);
    }

}
