package de.springbootbuch.testing.persistence.jpa;

import de.springbootbuch.testing.persistence.jpa.UserRepository;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@DataJpaTest
public class UserRepositoryJUnit4RuleTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private UserRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByDateOfBirthBeforeReturnsExpectedUsers() {

    }

}
