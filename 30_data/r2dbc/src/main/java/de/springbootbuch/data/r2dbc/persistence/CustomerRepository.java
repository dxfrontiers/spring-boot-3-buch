package de.springbootbuch.data.r2dbc.persistence;

import de.springbootbuch.data.r2dbc.persistence.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    Flux<Customer> findByLastName(String lastName);
    Flux<Customer> findByEmailLike(String emailPattern);
}
