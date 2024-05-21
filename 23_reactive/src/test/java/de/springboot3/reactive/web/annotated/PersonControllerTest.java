package de.springboot3.reactive.web.annotated;

import de.springboot3.reactive.model.Person;
import de.springboot3.reactive.service.PersonService;
import de.springboot3.reactive.service.sse.PersonFeedSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private PersonService personService;

    @MockBean
    private PersonFeedSource personFeedSource;

    @Test
    public void verifyFindByIdReturnsPerson() {
        Person expected = assemblePerson("Sansa", "Stark");

        when(personService.findById(1337L))
                .thenReturn(Mono.just(expected));

        webClient
                .get()
                .uri("/person/1337")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person.class)
                .isEqualTo(expected);
    }

    private Person assemblePerson(String firstName, String lastName) {
        return new Person()
                .setId(1337L)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setHouse(1L);
    }

}
