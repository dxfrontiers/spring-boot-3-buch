package de.springboot3.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

	public static void main(String[] args) {
		SpringApplication springApplication =
				new SpringApplication(EventsApplication.class);
		springApplication.addListeners(new MyApplicationListener());
		springApplication.run(args);
	}


}
