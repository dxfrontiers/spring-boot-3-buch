package de.springbootbuch.testing.service;

import de.springbootbuch.testing.properties.MailProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = MailSenderWithConfigService.class,
        initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(MailProperties.class)
public class MailSenderWithConfigServiceTest {

    @Autowired
    private MailSenderWithConfigService cut;

    @Test
    public void verifySendMail() {
        // ...
    }
}
