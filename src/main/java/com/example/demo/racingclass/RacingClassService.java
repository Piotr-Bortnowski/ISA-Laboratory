package com.example.demo.racingclass;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RacingClassService {

    private final RacingClassRepository repository;

    public RacingClassService(RacingClassRepository repository) {
        this.repository = repository;
    }

    public List<RacingClass> findAll() {
        return repository.findAll();
    }

    public Optional<RacingClass> find(UUID id) {
        return repository.findById(id);
    }

    public RacingClass create(String name, int maxHorsepower, int minWeight) {
        RacingClass racingClass = RacingClass.builder()
                .id(UUID.randomUUID())
                .name(name)
                .maxHorsepower(maxHorsepower)
                .minWeight(minWeight)
                .build();
        return repository.save(racingClass);
    }

    public void delete(RacingClass racingClass) {
        repository.delete(racingClass);
    }
}