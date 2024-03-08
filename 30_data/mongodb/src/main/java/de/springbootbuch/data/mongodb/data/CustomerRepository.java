package de.springbootbuch.data.mongodb.data;

import de.springbootbuch.data.mongodb.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByCustomerId(long customerId);

}
