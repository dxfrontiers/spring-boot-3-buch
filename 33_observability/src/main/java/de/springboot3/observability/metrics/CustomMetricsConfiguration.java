package de.springboot3.observability.metrics;

import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling // Using @Scheduled just to auto-trigger the metric
public class CustomMetricsConfiguration {

    @Bean
    public MeterFilter renameMetricsFilter() {
        return MeterFilter.renameTag(
                "currentUsers",
                "synthetic",
                "isSyntheticUser");
    }


}
