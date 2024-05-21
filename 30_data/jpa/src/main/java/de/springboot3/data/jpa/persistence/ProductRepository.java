package de.springboot3.data.jpa.persistence;

import de.springboot3.data.jpa.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByPriceLessThan(double maxPrice);
}
