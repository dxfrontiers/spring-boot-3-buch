package de.springboot3.testing.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties("weather")
public record WeatherServiceConnectionProperties(
        String url,
        int port,
        int maxRetries,
        Duration timeout,
        String token) {
}
