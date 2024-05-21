package de.springboot3.reactive.service.sse;

import de.springboot3.reactive.model.Person;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Component
public class PersonFeedSource implements AfterSaveCallback<Person> {

    private final Sinks.Many<Person> personSink = Sinks
            .many()
            .multicast()
            .directAllOrNothing();

    @Override
    public Publisher<Person> onAfterSave(Person entity, OutboundRow outboundRow, SqlIdentifier table) {
        personSink.tryEmitNext(entity);

        return Mono.just(entity);
    }

    public Flux<Person> asFeed() {
        return personSink.asFlux();
    }

}
