package de.springboot3.extending.application.customcondition;

import de.springboot3.extending.library.customcondition.CustomConditionalAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "client.enabled=true")
class CustomConditionalAutoConfigurationEnabledTest {

    @Autowired(required = false)
    private CustomConditionalAutoConfiguration autoConfiguration;

    @Test
    public void configurationIsNotLoaded() {
        assertThat(autoConfiguration).isNotNull();
    }


}