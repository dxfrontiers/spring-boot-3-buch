package de.springboot3.events.user;

import org.springframework.context.ApplicationEvent;

public class UserCreatedApplicationEvent extends ApplicationEvent {

    private final User user;

    public UserCreatedApplicationEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
