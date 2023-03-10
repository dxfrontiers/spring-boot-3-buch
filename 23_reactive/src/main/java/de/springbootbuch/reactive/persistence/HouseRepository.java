package de.springbootbuch.reactive.persistence;

import de.springbootbuch.reactive.model.House;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface HouseRepository extends ReactiveCrudRepository<House, Long> {

    Mono<House> findByName(String name);

}
