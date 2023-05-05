package de.springboot3.events.user;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void createUser(User user) {
        // store user in user database
        this.applicationEventPublisher.publishEvent(new UserCreatedEvent(user));
    }

    public void lockUser(int userId) {
        // lock user in user database
        this.applicationEventPublisher.publishEvent(new UserLockedEvent(userId));
    }

    public void unlockUser(int userId) {
        // unlock user in user database
        this.applicationEventPublisher.publishEvent(new UserUnlockedEvent(userId));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
