package de.springbootbuch.testing.service;

import de.springbootbuch.testing.model.AdContent;
import de.springbootbuch.testing.model.MailContent;
import de.springbootbuch.testing.model.User;
import org.springframework.stereotype.Service;

@Service
public class AdContentTemplateService {

    public MailContent template(AdContent content, User user) {
        return new MailContent("me", "not-me", "generated-html-mail");
    }
}
