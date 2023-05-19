package de.springboot3.extending.application.conditional;

import de.springboot3.extending.library.conditional.ConditionalAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "client.enabled=true")
class ConditionalAutoConfigurationEnabledTest {

    @Autowired(required = false)
    private ConditionalAutoConfiguration autoConfiguration;

    @Test
    public void configurationIsNotLoaded() {
        assertThat(autoConfiguration).isNotNull();
    }


}