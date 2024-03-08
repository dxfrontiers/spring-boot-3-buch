package de.springbootbuch.data.commons.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByFirstName() {

    }
}
