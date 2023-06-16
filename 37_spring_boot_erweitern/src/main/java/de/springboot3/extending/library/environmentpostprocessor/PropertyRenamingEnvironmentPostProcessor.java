package de.springboot3.extending.library.environmentpostprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class PropertyRenamingEnvironmentPostProcessor
        implements EnvironmentPostProcessor {

    private static final String OLD_PROPERTY_NAME = "old.property";
    private static final String NEW_PROPERTY_NAME = "renamed.property";

    @Override
    public void postProcessEnvironment(
            ConfigurableEnvironment environment,
            SpringApplication application) {
        String oldPropertyValue = environment.getProperty(OLD_PROPERTY_NAME);
        if (oldPropertyValue != null) {
            environment.getPropertySources().addFirst(new MapPropertySource(
                    "renamed",
                    Map.of(NEW_PROPERTY_NAME, oldPropertyValue)
            ));
        }
    }
}
