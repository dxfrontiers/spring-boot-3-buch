package de.springboot3.reactive.service;

import de.springboot3.reactive.model.House;
import de.springboot3.reactive.persistence.HouseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public Mono<House> findByName(String name) {
        return houseRepository.findByName(name);
    }

}
