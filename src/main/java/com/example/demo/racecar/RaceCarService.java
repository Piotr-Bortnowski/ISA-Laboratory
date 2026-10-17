package com.example.demo.racecar;


import com.example.demo.racingclass.RacingClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RaceCarService {
    private final RaceCarRepository repository;

    public RaceCarService(RaceCarRepository repository) {
        this.repository = repository;
    }

    public List<RaceCar> findAll() {
        return repository.findAll();
    }

    public Optional<RaceCar> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<RaceCar> findAllByRacingClass(RacingClass racingClass) {
        return repository.findAllByRacingClass(racingClass);
    }

    public RaceCar create(String modelName, int startNumber, double engineDisplacement,
                          boolean hybridPowertrain, RacingClass racingClass) {
        RaceCar raceCar = RaceCar.builder()
                .id(UUID.randomUUID())
                .modelName(modelName)
                .startNumber(startNumber)
                .engineDisplacement(engineDisplacement)
                .hybridPowertrain(hybridPowertrain)
                .racingClass(racingClass)
                .build();
        return repository.save(raceCar);
    }

    public void delete(RaceCar raceCar) {
        repository.delete(raceCar)  ;
    }
}
