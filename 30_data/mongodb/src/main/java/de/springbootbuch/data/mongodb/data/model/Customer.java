package de.springbootbuch.data.mongodb.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    @Indexed
    private Long customerId;

    private String firstName;
    private String lastName;

    @Indexed
    private String email;

    @DBRef
    private List<Address> addresses = new ArrayList<>();
}
