package de.springboot3.reactive.persistence;

import de.springboot3.reactive.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
    Flux<Person> findByLastName(String lastName);
}
