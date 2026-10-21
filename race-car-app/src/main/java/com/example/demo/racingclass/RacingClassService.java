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

    public RacingClass create(UUID id) {
        RacingClass racingClass = RacingClass.builder()
                .id(id)
                .build();
        return repository.save(racingClass);
    }

    public void delete(RacingClass racingClass) {
        repository.delete(racingClass);
    }

    public void save(RacingClass racingClass) {
        repository.save(racingClass);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}