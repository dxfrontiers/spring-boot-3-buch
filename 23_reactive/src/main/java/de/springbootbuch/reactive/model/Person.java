package de.springbootbuch.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("PERSON")
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Long house;
}
