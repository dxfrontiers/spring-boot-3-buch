package de.springboot3.extending.application.conditional;

import de.springboot3.extending.library.conditional.Client;
import de.springboot3.extending.library.conditional.ConditionalAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ConditionalAutoConfigurationTest {

    ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(ConditionalAutoConfiguration.class));

    @Test
    public void clientIsAvailableWithPropertyTrue() {
        runner
                .withPropertyValues("client.enabled=true")
                .run(context -> {
                    assertThat(context.getBean(Client.class)).isNotNull();
                });
    }

    @Test
    public void clientIsNotAvailableWithPropertyFalse() {
        runner
                .withPropertyValues("client.enabled=false")
                .run(context ->
                        assertThatThrownBy(() -> context.getBean(Client.class))
                                .isInstanceOf(NoSuchBeanDefinitionException.class));
    }


}