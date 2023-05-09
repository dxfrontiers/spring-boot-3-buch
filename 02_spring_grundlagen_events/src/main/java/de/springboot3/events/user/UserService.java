package de.springboot3.events.user;

import de.springboot3.events.common.User;
import de.springboot3.events.common.UserCreatedEvent;
import de.springboot3.events.common.UserLockedEvent;
import de.springboot3.events.common.UserUnlockedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createUser(User user) {
        // ... business logic omitted
        this.applicationEventPublisher.publishEvent(new UserCreatedEvent(user));
    }

    public void lockUser(int userId) {
        // ... business logic omitted
        this.applicationEventPublisher.publishEvent(new UserLockedEvent(userId));
    }

    public void unlockUser(int userId) {
        // ... business logic omitted
        this.applicationEventPublisher.publishEvent(new UserUnlockedEvent(userId));
    }

}
