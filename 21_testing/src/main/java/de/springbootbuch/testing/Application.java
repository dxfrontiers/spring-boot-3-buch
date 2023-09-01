package de.springbootbuch.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaRepositories(basePackages = "de.springbootbuch.testing.persistence.jpa")
@EnableJdbcRepositories(basePackages = "de.springbootbuch.testing.persistence.jdbc")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
