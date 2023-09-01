package de.springbootbuch.testing.persistence.jpa;

import de.springbootbuch.testing.persistence.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByDateOfBirthBeforeReturnsExpectedUsers() {

    }

}
