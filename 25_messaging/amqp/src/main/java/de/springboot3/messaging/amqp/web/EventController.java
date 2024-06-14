package de.springboot3.messaging.amqp.web;

import de.springboot3.messaging.amqp.service.producer.EventProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
public class EventController {

    private final EventProducer eventProducer;

    public EventController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping
    public void produceEvent(@RequestParam String name) {
        eventProducer.produceEvent(name);
    }

}
