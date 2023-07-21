package de.springbootbuch.testing.service;

import de.springbootbuch.testing.model.User;
import de.springbootbuch.testing.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findUsersOlderThan(int age) {
        return userRepository
                .findByDateOfBirthBefore(ZonedDateTime.now().minusYears(age));
    }

}
