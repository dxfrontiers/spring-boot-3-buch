package de.springboot3.messaging.jms.service.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @JmsListener(destination = "greetings")
    public void onMessage(String message) {
        System.out.println(message);
    }

}
