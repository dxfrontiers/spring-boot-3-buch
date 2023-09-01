package de.springbootbuch.testing.service;

import de.springbootbuch.testing.properties.WeatherServiceConnectionProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherService {

    private final Environment environment;
    private final WeatherServiceConnectionProperties connectionProperties;

}
