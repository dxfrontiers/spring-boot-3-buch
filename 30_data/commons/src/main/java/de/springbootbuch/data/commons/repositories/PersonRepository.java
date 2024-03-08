package de.springbootbuch.data.commons.repositories;

import de.springbootbuch.data.commons.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
}
