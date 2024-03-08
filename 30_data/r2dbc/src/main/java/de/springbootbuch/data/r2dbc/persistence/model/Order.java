package de.springbootbuch.data.r2dbc.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    private Long customerId;

    @JsonIgnore
    @Transient
    private Customer customer;

    @Transient
    private List<Product> products = new ArrayList<>();

}
