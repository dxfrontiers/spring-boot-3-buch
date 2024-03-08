package de.springbootbuch.data.r2dbc.persistence.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    private String name;
    private double price;
}
