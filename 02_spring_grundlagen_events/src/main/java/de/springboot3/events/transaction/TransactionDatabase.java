package de.springboot3.events.transaction;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionDatabase {

    private Map<Integer, User> users = new HashMap<>();

    public void saveUser(User user){
        this.users.put(user.id(), user);
    }

    public User getUser(int userId){
        return this.users.get(userId);
    }


}
