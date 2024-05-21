package de.springboot3.reactive.service;

import de.springboot3.reactive.exceptions.PersonNotFoundException;
import de.springboot3.reactive.model.Person;
import de.springboot3.reactive.persistence.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService cut;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void verifyDeleteByNameReturnsPersonAfterDeletion() {
        Person expected = assemblePerson("Sansa", "Stark");

        when(personRepository.findByFirstNameAndLastName("Sansa", "Stark"))
                .thenReturn(Mono.just(expected));
        when(personRepository.deleteById(1337L)).thenReturn(Mono.empty());

        StepVerifier
                .create(cut.deleteByName(expected.getFirstName(), expected.getLastName()))
                .expectNext(expected)
                .verifyComplete();
    }

    @Test
    public void verifyDeleteByNameThrowsErrorForUnknownPerson() {
        when(personRepository.findByFirstNameAndLastName(anyString(), anyString()))
                .thenReturn(Mono.empty());

        StepVerifier
                .create(cut.deleteByName("Sansa", "Lannister"))
                .expectError(PersonNotFoundException.class)
                .verify();
    }

    @Test
    public void verifyFindByIdReturnsExpectedPerson() {
        Person expected = assemblePerson("Sansa", "Stark");

        when(personRepository.findById(1337L)).thenReturn(Mono.just(expected));

        StepVerifier
                .create(cut.findById(1337L))
                .expectNext(expected)
                .verifyComplete();
    }

    private Person assemblePerson(String firstName, String lastName) {
        return new Person()
                .setId(1337L)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setHouse(1L);
    }
}
