package de.springbootbuch.testing.configuration;

import de.springbootbuch.testing.properties.WeatherServiceConnectionProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@TestConfiguration
public class WeatherServiceTestConfiguration {

    @Bean
    @Primary
    public WeatherServiceConnectionProperties properties() {
        return new WeatherServiceConnectionProperties(
                "https://local.weather.com", 8082, 2, Duration.ofSeconds(5), "a_token"
        );
    }

}
