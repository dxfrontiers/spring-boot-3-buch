package de.springbootbuch.data.r2dbc.persistence.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @Transient
    private List<Order> orders = new ArrayList<>();

}
