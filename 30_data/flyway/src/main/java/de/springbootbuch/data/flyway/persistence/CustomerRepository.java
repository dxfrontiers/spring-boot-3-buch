package de.springbootbuch.data.flyway.persistence;

import de.springbootbuch.data.flyway.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByEmailLike(String emailPattern);

    @Query("SELECT DISTINCT c FROM Customer c JOIN FETCH c.orders o")
    List<Customer> findAllCustomersWithOrders();
}
