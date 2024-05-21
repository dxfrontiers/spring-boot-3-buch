package de.springboot3.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MailSenderService.class)
public class MailSenderServiceIntegrationTest {

    @Autowired
    private MailSenderService cut;

    @Test
    public void verifySendingAMailIsWorking() {
        // ...
    }
}
