package de.springboot3.configuration.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    private final Environment environment;
    private final WeatherServiceConnectionProperties connectionProperties;

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    public WeatherService(
            Environment environment,
            WeatherServiceConnectionProperties connectionProperties) {
        this.environment = environment;
        this.connectionProperties = connectionProperties;

        logger.info("Connecting to weather service with these connection properties: {}", this.connectionProperties);
        logger.info("Active profiles: {}", environment.getActiveProfiles());
        logger.info("Value of 'custom.app-name': {}", environment.getProperty("custom.app-name"));
    }

}
