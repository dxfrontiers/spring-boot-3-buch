package de.springboot3.configuration.weather;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@ConfigurationProperties(prefix = "weather")
public record WeatherServiceConnectionProperties(
        @URL(protocol = "https") @NotNull String url,
        @NotNull Integer port,
        @NotNull Integer maxRetries,
        @NotNull Duration timeout,
        @NotNull String token
) {}
