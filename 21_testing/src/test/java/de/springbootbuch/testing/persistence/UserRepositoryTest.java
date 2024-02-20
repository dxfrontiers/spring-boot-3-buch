package de.springbootbuch.testing.persistence;

import de.springbootbuch.testing.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByDateOfBirthBeforeReturnsExpectedUsers() {
        entityManager.persist(assembleUser());

        List<User> users = cut.findByDateOfBirthBefore(ZonedDateTime.now());

        assertThat(users).hasSize(1);
    }

    private User assembleUser() {
        return new User()
                .setFirstName("Zaphod")
                .setLastName("Beeblebrox")
                .setEmail("zaphod.beeblebrox@superior.being")
                .setDateOfBirth(ZonedDateTime.now().minusYears(42));
    }
}
