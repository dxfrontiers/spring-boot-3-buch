package de.springbootbuch.testing.service;

import de.springbootbuch.testing.properties.WeatherServiceConnectionProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@SpringBootTest
public class WeatherServiceTestCfgTest {

    @Autowired
    private WeatherService cut;

    @TestConfiguration
    static class Configuration {
        @Bean
        @Primary
        public WeatherServiceConnectionProperties properties() {
            return new WeatherServiceConnectionProperties(
                    "https://local.weather.com", 8082, 2, Duration.ofSeconds(5), "a_token"
            );
        }
    }

    @Test
    public void test() {
        // ...
        cut.hashCode();
    }

}
