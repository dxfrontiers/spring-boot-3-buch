package de.springbootbuch.data.mongodb.data;

import de.springbootbuch.data.mongodb.data.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
