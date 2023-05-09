package de.springboot3.events.transaction;

import de.springboot3.events.common.UserCreatedApplicationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListener implements ApplicationListener<UserCreatedApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(UserCreatedEventListener.class);

    private final TransactionDatabase database;

    public UserCreatedEventListener(TransactionDatabase database) {
        this.database = database;
    }

    @Override
    public void onApplicationEvent(UserCreatedApplicationEvent event) {
        this.database.saveUser(new User(event.getUser().id(), User.UNLOCKED));
        logger.info("received event: {}", event);
    }
}
