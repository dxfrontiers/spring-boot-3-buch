package de.springboot3.data.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "de.springbootbuch.data.commons.repositories")
public class PersistenceConfiguration {
}
