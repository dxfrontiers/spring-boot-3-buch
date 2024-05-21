package de.springboot3.testing.service;

import de.springboot3.testing.model.AdContent;
import de.springboot3.testing.model.MailContent;
import de.springboot3.testing.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @InjectMocks
    private AdvertisementService cut;

    @Mock
    private UserService userService;

    @Mock
    private MailSenderService mailSenderService;

    @Mock
    private AdContentTemplateService adContentTemplateService;

    @Test
    public void verifyTriggerAdvertisementPerformsSendMail() {
        AdContent adContent = assembleAdContent();

        when(userService.findUsersOlderThan(adContent.minAge())).thenReturn(Arrays.asList(
                assembleUser("Mike", "Johnson", 42),
                assembleUser("Andy", "Goldfield", 31)
        ));
        when(adContentTemplateService.template(any(AdContent.class), any(User.class)))
                .thenReturn(mock(MailContent.class));

        cut.triggerAdvertisement(adContent);

        verify(mailSenderService, times(2)).sendMail(any(MailContent.class));
    }

    private AdContent assembleAdContent() {
        return new AdContent("some content", 30);
    }

    private User assembleUser(String firstName, String lastName, int age) {
        return new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDateOfBirth(ZonedDateTime.now().minusYears(age));
    }
}
