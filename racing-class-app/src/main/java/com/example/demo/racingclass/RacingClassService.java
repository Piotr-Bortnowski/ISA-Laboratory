package com.example.demo.racingclass;

import com.example.demo.racingclass.event.RacingClassEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RacingClassService {

    private final RacingClassRepository repository;
    private final RacingClassEventRepository eventRepository;

    public RacingClassService(RacingClassRepository repository,  RacingClassEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public List<RacingClass> findAll() {
        return repository.findAll();
    }

    public Optional<RacingClass> find(UUID id) {
        return repository.findById(id);
    }


    // create -> actually creates a new class so event is needed
    public void create(RacingClass racingClass) {
        repository.save(racingClass);
        eventRepository.create(racingClass.getId());
    }

    // save -> just update an existing class
    public void save(RacingClass racingClass) {
        repository.save(racingClass);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
        eventRepository.delete(id);
    }
}