package de.springboot3.reactive.exceptions;

public class ExternalCommunicationException extends RuntimeException {

    private final int statusCode;

    public ExternalCommunicationException(int statusCode) {
        this("Communication failed due to server error", statusCode);
    }

    public ExternalCommunicationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
