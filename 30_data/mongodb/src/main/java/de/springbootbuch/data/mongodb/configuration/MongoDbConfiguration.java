package de.springbootbuch.data.mongodb.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfiguration {

    @Bean
    public MongoClientSettingsBuilderCustomizer mongoClientSettingsBuilderCustomizer() {
        return settings -> settings
                .applyToSslSettings(ssl -> ssl.enabled(true));
    }
}
