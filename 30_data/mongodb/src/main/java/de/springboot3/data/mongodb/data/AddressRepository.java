package de.springboot3.data.mongodb.data;

import de.springboot3.data.mongodb.data.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
