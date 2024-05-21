package de.springboot3.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class MailSenderServiceWithCtxTest {

    @Autowired
    private MailSenderService cut;

    @Configuration
    static class Config {
        @Bean
        MailSenderService mailSenderService() {
            return new MailSenderService();
        }
    }

    @Test
    public void verifySendingAMailIsWorking() {
        // ...
    }
}
