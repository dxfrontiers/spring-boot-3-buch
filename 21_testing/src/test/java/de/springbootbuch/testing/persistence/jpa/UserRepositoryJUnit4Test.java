package de.springbootbuch.testing.persistence.jpa;

import de.springbootbuch.testing.persistence.jpa.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryJUnit4Test {

    @Autowired
    private UserRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByDateOfBirthBeforeReturnsExpectedUsers() {

    }

}
