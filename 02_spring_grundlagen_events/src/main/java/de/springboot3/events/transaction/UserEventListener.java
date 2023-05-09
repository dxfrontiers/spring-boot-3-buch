package de.springboot3.events.transaction;

import de.springboot3.events.common.UserCreatedEvent;
import de.springboot3.events.common.UserLockedEvent;
import de.springboot3.events.common.UserUnlockedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    private static final Logger logger = LoggerFactory.getLogger(UserEventListener.class);

    private final TransactionDatabase database;

    public UserEventListener(TransactionDatabase database) {
        this.database = database;
    }

    @Async
    @EventListener(UserCreatedEvent.class)
    public void onUserCreated(UserCreatedEvent event) {
        this.database.saveUser(new User(event.user().id(), User.UNLOCKED));
        logger.info("received event: {}", event);
        throw new RuntimeException("BWAAH");
    }

    @EventListener(UserLockedEvent.class)
    public void onUserLocked(UserLockedEvent event) {
        this.database.saveUser(new User(event.userId(), User.LOCKED));
        logger.info("received event: {}", event);
    }

    @EventListener(UserUnlockedEvent.class)
    public void onUserUnlocked(UserUnlockedEvent event) {
        this.database.saveUser(new User(event.userId(), User.UNLOCKED));
        logger.info("received event: {}", event);
    }

}
