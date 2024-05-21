package de.springboot3.testing.service;

import de.springboot3.testing.properties.WeatherServiceConnectionProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    private final Environment environment;
    private final WeatherServiceConnectionProperties connectionProperties;

    public WeatherService(Environment environment, WeatherServiceConnectionProperties connectionProperties) {
        this.environment = environment;
        this.connectionProperties = connectionProperties;
    }
}
