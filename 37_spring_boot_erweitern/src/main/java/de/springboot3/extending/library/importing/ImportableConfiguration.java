package de.springboot3.extending.library.importing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportableConfiguration {

    @Bean
    public Client client(){
        return new Client();
    }

}
