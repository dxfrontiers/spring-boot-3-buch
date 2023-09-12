package de.springboot3.observability.pipeline;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnResource(resources = "/pipeline.properties")
public class PipelineInfoAutoConfiguration {

    @Bean
    InfoContributor pipelineInfoContributor() {
        return new PipelineInfoContributor("/pipeline.properties");
    }

}
