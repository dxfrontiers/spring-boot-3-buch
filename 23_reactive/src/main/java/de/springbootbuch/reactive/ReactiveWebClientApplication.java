package de.springbootbuch.reactive;

import de.springbootbuch.reactive.exceptions.ExternalCommunicationException;
import de.springbootbuch.reactive.rest.model.PersonResponse;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

public class ReactiveWebClientApplication {

    public static void main(String[] args) throws InterruptedException {

        /*
        // simple variant with WebClient.create

        WebClient webClient = WebClient.create("http://localhost:8080");
         */

        /*
        // still simple variant, however already using the WebClient.Builder

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        */

        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10_000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)));

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new ExternalCommunicationException(
                                response.statusCode().value())))
                .build();

        Flux<PersonResponse> findByName = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/person")
                        .queryParam("lastName", "{lastName}")
                        .build("Stark"))
                .retrieve()
                .bodyToFlux(PersonResponse.class);

        findByName.subscribe(System.out::println);

        Mono<PersonResponse> findById = webClient
                .get()
                .uri("/person/1337")
                .retrieve()
                .bodyToMono(PersonResponse.class);

        findById.subscribe(System.out::println);

        Thread.sleep(Duration.ofSeconds(5));
    }

}
