package de.springboot3.troubleshooting.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UnusedPropertyDetector implements EnvironmentPostProcessor, ApplicationListener<ApplicationReadyEvent> {

    private final ConfigurableEnvironment environment;
    private final Logger logger = LoggerFactory.getLogger(UnusedPropertyDetector.class);

    public UnusedPropertyDetector(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        environment.getPropertySources()
                .stream()
                .filter(propertySource -> propertySource instanceof EnumerablePropertySource<?>)
                .map(EnumerablePropertySource.class::cast)
                .forEach(propertySource -> environment.getPropertySources().replace(propertySource.getName(), new RecordingPropertySource(propertySource)));
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        environment.getPropertySources().stream()
                .filter(propertySource -> propertySource instanceof RecordingPropertySource)
                .map(RecordingPropertySource.class::cast)
                .forEach(propertySource -> logger.info("Unused properties from propertySource '{}': {}",
                        propertySource.getName(),
                        propertySource
                                .getUnusedProperties()
                                .orElseGet(Collections::emptySet)));
    }
}
