package de.springboot3.messaging.amqp.service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @RabbitListener(queues = "greetings")
    public void onMessage(String message) {
        System.out.println(message);
    }

}
