package de.springboot3.troubleshooting.properties;

import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class RecordingPropertySource extends MapPropertySource {

    private final Set<String> usedProperties = new HashSet<>();

    public RecordingPropertySource(EnumerablePropertySource<?> delegate) {
        super(delegate.getName(), extractProperties(delegate));
    }

    @Override
    public Object getProperty(String name) {
        usedProperties.add(name);
        return super.getProperty(name);
    }

    public Set<String> getUsedProperties() {
        return Set.copyOf(usedProperties);
    }

    public Optional<Set<String>> getUnusedProperties() {
        return Optional.of(Arrays.stream(getPropertyNames())
                .filter(propertyName -> !this.usedProperties.contains(propertyName))
                .collect(Collectors.toSet()));
    }

    private static Map<String, Object> extractProperties(EnumerablePropertySource<?> propertySource) {
        Map<String, Object> properties = new HashMap<>();
        Arrays.stream(propertySource.getPropertyNames())
                .forEach(propertyName -> properties.put(
                        propertyName,
                        propertySource.getProperty(propertyName)));
        return properties;
    }
}
