package de.springbootbuch.data.r2dbc.persistence;


import de.springbootbuch.data.r2dbc.persistence.model.Order;
import de.springbootbuch.data.r2dbc.persistence.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findByCustomerId(Long customerId);

    @Query("SELECT p.* FROM order_products op INNER JOIN products p ON op.product_id = p.id WHERE op.order_id = $1")
    Flux<Product> findProductsByOrderId(Long orderId);
}
