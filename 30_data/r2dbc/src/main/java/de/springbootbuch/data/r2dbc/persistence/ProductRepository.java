package de.springbootbuch.data.r2dbc.persistence;

import de.springbootbuch.data.r2dbc.persistence.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Product> findByName(String name);
    Flux<Product> findByPriceLessThan(double maxPrice);
}
