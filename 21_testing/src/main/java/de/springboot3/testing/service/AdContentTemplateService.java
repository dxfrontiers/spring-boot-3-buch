package de.springboot3.testing.service;

import de.springboot3.testing.model.AdContent;
import de.springboot3.testing.model.MailContent;
import de.springboot3.testing.model.User;
import org.springframework.stereotype.Service;

@Service
public class AdContentTemplateService {

    public MailContent template(AdContent content, User user) {
        return new MailContent("me", "not-me", "generated-html-mail");
    }
}
