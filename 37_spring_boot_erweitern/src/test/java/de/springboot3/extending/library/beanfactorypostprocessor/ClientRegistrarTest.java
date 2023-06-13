package de.springboot3.extending.library.beanfactorypostprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ClientRegistrarTest {

    ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(UserConfigurations.of(BeanDefinitionRegistryPostProcessorConfiguration.class));

    @Test
    void registersClientsFromBaseUrlProperties() {
        runner.withPropertyValues(
                        "client1.baseUrl=http://foo1.bar",
                        "client2.baseUrl=http://foo2.bar")
                .run((context) -> {
                    Map<String, Client> clients = context.getBeansOfType(Client.class);
                    assertThat(clients.get("client1").getBaseUrl()).isEqualTo("http://foo1.bar");
                    assertThat(clients.get("client2").getBaseUrl()).isEqualTo("http://foo2.bar");
                });
    }

}