package de.springboot3.extending.application.importing;

import de.springboot3.extending.library.importing.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;


class ImportableConfigurationTest {

    ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(ImportingConfiguration.class));


    @Test
    public void clientIsAvailable() {
        runner.run(context -> {
            assertThat(context.getBean(Client.class)).isNotNull();
        });
    }


}