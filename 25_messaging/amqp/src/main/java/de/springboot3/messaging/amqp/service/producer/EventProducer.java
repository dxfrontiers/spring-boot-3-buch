package de.springboot3.messaging.amqp.service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final RabbitTemplate rabbitTemplate;

    public EventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceEvent(String name) {
        rabbitTemplate.convertAndSend("greetings", "Hello " + name);
    }

}
