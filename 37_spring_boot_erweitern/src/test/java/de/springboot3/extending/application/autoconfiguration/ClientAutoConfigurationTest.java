package de.springboot3.extending.application.autoconfiguration;

import de.springboot3.extending.library.autoconfiguration.ClientAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ClientAutoConfigurationTest {

    @Autowired
    private ClientAutoConfiguration autoConfiguration;

    @Test
    public void configurationIsLoaded(){
        assertThat(autoConfiguration).isNotNull();
    }

}