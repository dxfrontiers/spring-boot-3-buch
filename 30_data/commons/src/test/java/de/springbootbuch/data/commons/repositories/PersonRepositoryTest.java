package de.springbootbuch.data.commons.repositories;

import de.springbootbuch.data.commons.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindByFirstName() {
        Person person = new Person().setFirstName("John").setLastName("McKinsey");

        entityManager.persistAndFlush(person);

        assertThat(cut.findByFirstName("John")).satisfiesExactly(
                first -> assertThat(first).isEqualTo(person)
        );
        assertThat(cut.findByFirstName("Barbara")).isEmpty();
    }
}
