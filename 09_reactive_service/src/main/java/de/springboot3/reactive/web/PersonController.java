package de.springboot3.reactive.web;

import de.springboot3.reactive.model.Person;
import de.springboot3.reactive.persistence.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{id}")
    public Mono<Person> findById(@PathVariable Long id) {
        return personRepository
                .findById(id)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))));
    }

    @GetMapping("/by-last-name")
    public Flux<Person> findByLastName(@RequestParam String lastName) {
        return personRepository.findByLastName(lastName);
    }
}
