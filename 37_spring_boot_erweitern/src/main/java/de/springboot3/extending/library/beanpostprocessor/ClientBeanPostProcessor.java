package de.springboot3.extending.library.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClientBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(
            Object bean,
            String beanName)
            throws BeansException {
        if (bean instanceof Client) {
            Client client = (Client) bean;
            if (client.getBaseUrl() != null
                    && !client.getBaseUrl().startsWith("https://")) {
                throw new BeanInitializationException("Client is not using HTTPS!");
            }
        }
        return bean;
    }
}
