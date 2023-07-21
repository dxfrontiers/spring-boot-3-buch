package de.springbootbuch.reactive.intro;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IntroExamples {

    public static void main(String[] args) {
        IntroExamples main = new IntroExamples();

        main.just();
        main.defer();
        main.fromSupplier();
        main.publisherConversion();
    }

    private void just() {
        Mono<UUID> uuid = Mono.just(UUID.randomUUID());

        uuid.subscribe(System.out::println);
        // ade9596d-bbdf-441f-816d-301e60744116
        uuid.subscribe(System.out::println);
        // ade9596d-bbdf-441f-816d-301e60744116
    }

    private void defer() {
        Mono<UUID> uuid = Mono
                .defer(() -> Mono.just(UUID.randomUUID()));

        uuid.subscribe(System.out::println);
        // 29c9efba-834b-43f0-bd9d-4a26d59701a9
        uuid.subscribe(System.out::println);
         // 47887e2a-67e6-4818-90d7-cf431beda1ea
    }

    private void fromSupplier() {
        Mono<UUID> uuid = Mono.fromSupplier(UUID::randomUUID);

        uuid.subscribe(System.out::println);
        // 71540797-6914-465e-8624-c39fbe85e174
        uuid.subscribe(System.out::println);
        // 895594b2-fc75-4f77-9755-79dbe7eb25c7
    }

    private void publisherConversion() {
        Mono
                .just(424242L)
                // Mono<Long>
                .flatMapMany(this::primeFactors)
                // Flux<Long>
                .reduce("Prime Factors:", (l, r) -> String.format("%s %s", l, r))
                // Mono<String>
                .subscribe(System.out::println);
                // 2 3 3 7 7 13 37
    }

    private Flux<Long> primeFactors(long number) {
        List<Long> factors = new ArrayList<>();

        for (long factor = 2; factor <= number; factor++) {
            while (number % factor == 0) {
                factors.add(factor);
                number = number / factor;
            }
        }

        return Flux.fromIterable(factors);
    }
}
