package de.springboot3.extending.application.importing;

import de.springboot3.extending.library.importing.ImportableConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ImportableConfiguration.class)
class ImportingConfiguration {

}
