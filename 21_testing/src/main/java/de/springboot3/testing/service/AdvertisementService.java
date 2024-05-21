package de.springboot3.testing.service;

import de.springboot3.testing.model.AdContent;
import de.springboot3.testing.model.MailContent;
import de.springboot3.testing.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    private final UserService userService;
    private final MailSenderService mailSenderService;
    private final AdContentTemplateService adContentTemplateService;

    public AdvertisementService(UserService userService, MailSenderService mailSenderService, AdContentTemplateService adContentTemplateService) {
        this.userService = userService;
        this.mailSenderService = mailSenderService;
        this.adContentTemplateService = adContentTemplateService;
    }

    public void triggerAdvertisement(AdContent ad) {
        List<User> usersOlderThan = userService.findUsersOlderThan(ad.minAge());

        usersOlderThan.forEach(user -> {
            MailContent mailContent = adContentTemplateService.template(ad, user);

            mailSenderService.sendMail(mailContent);
        });
    }

}
