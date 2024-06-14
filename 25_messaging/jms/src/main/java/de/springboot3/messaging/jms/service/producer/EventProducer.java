package de.springboot3.messaging.jms.service.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final JmsTemplate jmsTemplate;

    public EventProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void produceEvent(String name) {
        jmsTemplate.send("greetings", session -> session.createTextMessage("Hello " + name));
    }

}
