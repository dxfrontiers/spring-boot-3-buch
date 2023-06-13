package de.springboot3.extending.library.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.env.Environment;

import java.util.function.Supplier;

public class ClientRegistrar implements BeanDefinitionRegistryPostProcessor {

    private final Environment environment;

    public ClientRegistrar(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (int i = 0; i < 10; i++) {
            String baseUrl = environment.getProperty("client" + i + ".baseUrl");
            if (baseUrl != null) {
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClassName("de.springboot3.extending.library.beanfactorypostprocessor.Client");
                beanDefinition.setInstanceSupplier((Supplier<Client>) () -> new Client(baseUrl));
                registry.registerBeanDefinition("client" + i, beanDefinition);
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // do nothing
    }
}
