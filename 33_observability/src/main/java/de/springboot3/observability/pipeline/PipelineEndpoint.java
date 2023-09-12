package de.springboot3.observability.pipeline;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Endpoint(id = "pipeline")
public class PipelineEndpoint {

    private final PipelineProperties pipelineProperties;

    public PipelineEndpoint(String propertiesPath) {
        this.pipelineProperties = readProperties(propertiesPath);
    }

    @ReadOperation
    public PipelineProperties getPipelineProperties() {
        return this.pipelineProperties;
    }

    private PipelineProperties readProperties(String propertiesPath) {
        Properties properties = new Properties();
        try (final InputStream stream =
                     getClass().getResourceAsStream(propertiesPath)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("error loading '%s'", propertiesPath));
        }
        return new PipelineProperties(
                properties.getProperty("pipeline.number", "unknown"),
                properties.getProperty("pipeline.url", "unknown")
        );
    }

    record PipelineProperties(
            String pipelineNumber,
            String pipelineUrl
    ) {
    }

}
