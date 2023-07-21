package de.springbootbuch.reactive.web.fn.routes;

import de.springbootbuch.reactive.web.fn.PersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.data.util.Predicates.isTrue;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class PersonRouter {

    private final PersonHandler personHandler;

    @Bean
    public RouterFunction<ServerResponse> personRoutes() {
        return route()
                .path("/fn/person", builder -> builder
                        .GET("/feed", personHandler::personFeed)
                        .GET("/{id}", personHandler::findById)
                        .GET(queryParam("lastName", isTrue()), personHandler::findByName))
                .build();
    }

}
