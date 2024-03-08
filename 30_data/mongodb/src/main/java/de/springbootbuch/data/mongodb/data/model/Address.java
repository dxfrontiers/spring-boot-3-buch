package de.springbootbuch.data.mongodb.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "addresses")
public class Address {

    @Id
    private String id;

    private String street;
    private String houseNumber;

    @Indexed
    private String postalCode;
    private String city;
    private String district;

}
