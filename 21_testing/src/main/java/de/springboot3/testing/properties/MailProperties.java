package de.springboot3.testing.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mail")
public record MailProperties(
        String server,
        int port) {
}
