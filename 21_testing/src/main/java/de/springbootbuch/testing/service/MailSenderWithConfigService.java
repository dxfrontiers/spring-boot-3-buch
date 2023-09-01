package de.springbootbuch.testing.service;

import de.springbootbuch.testing.model.MailContent;
import de.springbootbuch.testing.properties.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderWithConfigService {

    private final MailProperties mailProperties;

    public void sendMail(MailContent content) {
        // ...
    }

}
