package de.springboot3.observability.pipeline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelineEndpointConfiguration {

    @Bean
    PipelineEndpoint pipelineEndpoint() {
        return new PipelineEndpoint("/pipeline.properties");
    }

}
