package de.springboot3.data.flyway.persistence;

import de.springboot3.data.flyway.persistence.model.Customer;
import de.springboot3.data.flyway.persistence.model.Product;
import de.springboot3.data.flyway.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);
    List<Order> findByProductsContains(Product product);
    Long countOrdersByCustomerId(Long customerId);
    void deleteByCustomer(Customer customer);
}
