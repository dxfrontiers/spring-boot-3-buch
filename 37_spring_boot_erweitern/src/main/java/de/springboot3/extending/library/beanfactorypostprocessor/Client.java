package de.springboot3.extending.library.beanfactorypostprocessor;

/**
 * A Client to an external resource that we want to make available in multiple Spring Boot applications.
 * This is just a dummy placeholder for a real class we want to make available.
 */
public class Client {

    private final String baseUrl;

    public Client(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
