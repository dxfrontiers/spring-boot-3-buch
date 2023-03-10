package de.springbootbuch.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("HOUSES")
public class House {
    @Id
    private Long id;
    private String name;
    private String words;
}
