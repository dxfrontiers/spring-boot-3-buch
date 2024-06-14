package de.springboot3.messaging.kafka.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @KafkaListener(topics = "greetings", groupId = "messaging-application")
    public void onMessage(String message) {
        System.out.println(message);
    }

}
