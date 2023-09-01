package de.springbootbuch.testing.service;

import de.springbootbuch.testing.exceptions.UserNotFoundException;
import de.springbootbuch.testing.model.User;
import de.springbootbuch.testing.persistence.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
