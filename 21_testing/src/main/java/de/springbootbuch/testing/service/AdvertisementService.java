package de.springbootbuch.testing.service;

import de.springbootbuch.testing.model.AdContent;
import de.springbootbuch.testing.model.MailContent;
import de.springbootbuch.testing.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementService {

    private final UserService userService;
    private final MailSenderService mailSenderService;
    private final AdContentTemplateService adContentTemplateService;

    public void triggerAdvertisement(AdContent ad) {
        List<User> usersOlderThan = userService.findUsersOlderThan(ad.minAge());

        usersOlderThan.forEach(user -> {
            MailContent mailContent = adContentTemplateService.template(ad, user);

            mailSenderService.sendMail(mailContent);
        });
    }

}
