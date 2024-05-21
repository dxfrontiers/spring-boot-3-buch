package de.springboot3.reactive.rest.model;

public record PersonResponse(Long id,
                             String firstName,
                             String lastName,
                             Long house) {
}
