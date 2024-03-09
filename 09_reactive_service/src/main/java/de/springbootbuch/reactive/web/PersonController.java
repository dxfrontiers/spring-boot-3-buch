package de.springbootbuch.reactive.web;

import de.springbootbuch.reactive.model.Person;
import de.springbootbuch.reactive.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

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
