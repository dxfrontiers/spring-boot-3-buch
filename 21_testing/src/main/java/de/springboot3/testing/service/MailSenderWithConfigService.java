package de.springboot3.testing.service;

import de.springboot3.testing.model.MailContent;
import de.springboot3.testing.properties.MailProperties;
import org.springframework.stereotype.Service;

@Service
public class MailSenderWithConfigService {

    private final MailProperties mailProperties;

    public MailSenderWithConfigService(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }

    public void sendMail(MailContent content) {
        // ...
    }

}
