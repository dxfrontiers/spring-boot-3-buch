package de.springbootbuch.reactive.web.fn;

import de.springbootbuch.reactive.model.Person;
import de.springbootbuch.reactive.service.PersonService;
import de.springbootbuch.reactive.service.sse.PersonFeedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PersonHandler {

    private final PersonService personService;
    private final PersonFeedSource personFeedSource;

    public Mono<ServerResponse> findByName(ServerRequest request) {
        return request
                .queryParam("lastName")
                .map(lastName -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(personService.findByLastName(lastName), Person.class))
                .orElseGet(() -> ServerResponse.badRequest().build());
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return personService
                .findById(Long.valueOf(request.pathVariable("id")))
                .flatMap(person -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(person))
                .switchIfEmpty(Mono.defer(() -> ServerResponse.notFound().build()));
    }

    public Mono<ServerResponse> personFeed(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_NDJSON)
                .body(personFeedSource.asFeed(), Person.class);
    }

}
