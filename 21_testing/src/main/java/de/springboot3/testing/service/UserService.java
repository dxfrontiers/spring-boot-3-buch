package de.springboot3.testing.service;

import de.springboot3.testing.exceptions.UserNotFoundException;
import de.springboot3.testing.model.User;
import de.springboot3.testing.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsersOlderThan(int age) {
        return userRepository
                .findByDateOfBirthBefore(ZonedDateTime.now().minusYears(age));
    }

    public void update(long userId, Consumer<User> updater) {
        userRepository
                .findById(userId)
                .ifPresentOrElse(updater, () -> { throw new UserNotFoundException("User with given id was not found: " + userId); });
    }

}
