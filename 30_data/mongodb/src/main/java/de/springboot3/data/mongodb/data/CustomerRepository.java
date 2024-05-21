package de.springboot3.data.mongodb.data;

import de.springboot3.data.mongodb.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByCustomerId(long customerId);

}
