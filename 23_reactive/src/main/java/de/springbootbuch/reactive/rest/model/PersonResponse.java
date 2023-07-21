package de.springbootbuch.reactive.rest.model;

public record PersonResponse(Long id,
                             String firstName,
                             String lastName,
                             Long house) {
}
