package de.springbootbuch.reactive.service;

import de.springbootbuch.reactive.model.House;
import de.springbootbuch.reactive.persistence.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    public Mono<House> findByName(String name) {
        return houseRepository.findByName(name);
    }

}
