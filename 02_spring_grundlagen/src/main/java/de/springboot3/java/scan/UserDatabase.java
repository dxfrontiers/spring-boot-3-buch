package de.springboot3.java.scan;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
class UserDatabase {

    private final Map<Integer, User> users = Stream.of(
            new User(1, "Alice"),
            new User(2, "Bob"),
            new User(3, "Charlie")
    ).collect(Collectors.toMap(User::getId, Function.identity()));

    @Nullable
    User findUser(Integer userId) {
        return users.get(userId);
    }

}
