package de.springbootbuch.reactive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("PERSON")
public class Person {
    @Id
    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
