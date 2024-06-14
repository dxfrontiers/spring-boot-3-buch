package de.springboot3.messaging.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class MessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

	@Bean
	public NewTopic greetingsTopic() {
		// create a "greetings" topic with 1 partition and a replication factor of 1
		return TopicBuilder.name("greetings")
				.partitions(1)
				.replicas(1)
				.build();
	}

}
