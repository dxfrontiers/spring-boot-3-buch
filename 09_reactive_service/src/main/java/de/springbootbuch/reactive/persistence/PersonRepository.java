package de.springbootbuch.reactive.persistence;

import de.springbootbuch.reactive.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
    Flux<Person> findByLastName(String lastName);
}
