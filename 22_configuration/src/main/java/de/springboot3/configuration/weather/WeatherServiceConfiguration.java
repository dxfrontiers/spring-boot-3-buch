package de.springboot3.configuration.weather;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationPropertiesScan
@PropertySource("classpath:/de/springboot3/configuration/weather/weather.properties")
public class WeatherServiceConfiguration {

}
