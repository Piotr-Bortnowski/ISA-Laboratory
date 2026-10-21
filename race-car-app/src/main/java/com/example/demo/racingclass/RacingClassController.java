package com.example.demo.racingclass;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/racing-classes")
public class RacingClassController {
    private final RacingClassService racingClassService;

    public RacingClassController(RacingClassService racingClassService) {
        this.racingClassService = racingClassService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putRacingClass(@PathVariable UUID id) {
        if (racingClassService.find(id).isPresent()) {
            return ResponseEntity.noContent().build();
        }
        racingClassService.create(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRacingClass(@PathVariable UUID id) {
        if  (racingClassService.find(id).isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        racingClassService.delete(id);
    }
}
