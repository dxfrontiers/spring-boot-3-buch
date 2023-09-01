package de.springbootbuch.testing.persistence.jpa;

import de.springbootbuch.testing.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByDateOfBirthBefore(ZonedDateTime referenceDate);

}
