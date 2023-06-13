package de.springboot3.extending.library.beanpostprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ClientBeanPostProcessorTest {

    ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(UserConfigurations.of(ClientBeanPostProcessorConfiguration.class));

    @Test
    void failsWithHttpBaseUrl() {
        runner.withPropertyValues("client.baseUrl=http://foo.bar")
                .run((context) -> {
                    assertThatThrownBy(() -> {
                        context.getBean("beanPostProcessorExampleClient");
                    })
                            .hasRootCauseInstanceOf(BeanInitializationException.class)
                            .hasRootCauseMessage("Client is not using HTTPS!");
                });
    }

    @Test
    void succeedsWithHttpsBaseUrl() {
        runner.withPropertyValues("client.baseUrl=https://foo.bar")
                .run((context) -> {
                    context.getBean("beanPostProcessorExampleClient");
                    // no exception
                });
    }

}