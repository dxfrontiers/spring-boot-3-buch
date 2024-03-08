package de.springbootbuch.data.r2dbc.web.model;

public record UpdateCustomerRequest(
        String firstName,
        String lastName,
        String email
) {}
