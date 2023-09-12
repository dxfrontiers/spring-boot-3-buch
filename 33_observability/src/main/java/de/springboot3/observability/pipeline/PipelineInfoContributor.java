package de.springboot3.observability.pipeline;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PipelineInfoContributor implements InfoContributor {

    private final PipelineProperties pipelineProperties;

    public PipelineInfoContributor(String propertiesPath) {
        this.pipelineProperties = readProperties(propertiesPath);
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

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("pipeline",
                Map.of(
                        "pipeline.number", pipelineProperties.pipelineNumber(),
                        "pipeline.url", pipelineProperties.pipelineUrl()));
    }

    record PipelineProperties(
            String pipelineNumber,
            String pipelineUrl
    ) {}

}
