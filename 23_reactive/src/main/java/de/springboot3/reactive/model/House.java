package de.springboot3.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("HOUSES")
public class House {
    @Id
    private Long id;
    private String name;
    private String words;

    public Long getId() {
        return id;
    }

    public House setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public House setName(String name) {
        this.name = name;
        return this;
    }

    public String getWords() {
        return words;
    }

    public House setWords(String words) {
        this.words = words;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) && Objects.equals(name, house.name) && Objects.equals(words, house.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, words);
    }
}
