package de.springboot3.reactive.web.annotated;

import de.springboot3.reactive.exceptions.PersonNotFoundException;
import de.springboot3.reactive.model.Person;
import de.springboot3.reactive.service.PersonService;
import de.springboot3.reactive.service.sse.PersonFeedSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;
    private final PersonFeedSource personFeedSource;

    public PersonController(PersonService personService, PersonFeedSource personFeedSource) {
        this.personService = personService;
        this.personFeedSource = personFeedSource;
    }

    @GetMapping
    public Flux<Person> findByName(@RequestParam String lastName) {
        return personService.findByLastName(lastName);
    }

    @GetMapping("/{id}")
    public Mono<Person> findById(@PathVariable Long id) {
        return personService
                .findById(id)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))));
    }

    @GetMapping(path = "/feed", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Person> personFeed() {
        return personFeedSource.asFeed();
    }

    @PutMapping
    public Mono<ResponseEntity<String>> addPerson(@RequestParam String firstName, @RequestParam String lastName) {
        return personService
                .addPerson(firstName, lastName)
                .map(character -> ResponseEntity.status(HttpStatus.CREATED).<String>build())
                .switchIfEmpty(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())))
                .onErrorResume(PersonNotFoundException.class, ex -> Mono.just(ResponseEntity.badRequest().body(ex.getMessage())));
    }

    @DeleteMapping
    public Mono<Void> deleteByName(@RequestParam String firstName, @RequestParam String lastName) {
        return personService
                .deleteByName(firstName, lastName)
                .then();
    }

}
