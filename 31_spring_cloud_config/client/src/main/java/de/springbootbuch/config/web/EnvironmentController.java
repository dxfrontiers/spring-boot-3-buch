package de.springbootbuch.config.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("env")
@RequiredArgsConstructor
public class EnvironmentController {

    private final Environment environment;
    @Value("${weather-service.url}")
    private String weatherServiceUrl;

    @GetMapping
    public String getProperty(@RequestParam String key) {
        return environment.getProperty(key);
    }

    @GetMapping("/weather")
    public String getWeatherServiceUrl() {
        return weatherServiceUrl;
    }
}
