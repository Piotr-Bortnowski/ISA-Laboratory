package com.example.demo.racingclass;

import com.example.demo.racingclass.dto.GetRacingClassResponse;
import com.example.demo.racingclass.dto.GetRacingClassesResponse;
import com.example.demo.racingclass.dto.PutRacingClassRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RacingClassController {
    private final RacingClassService racingClassService;

    public RacingClassController(RacingClassService racingClassService) {
        this.racingClassService = racingClassService;
    }

    @GetMapping("/racing-classes")
    public GetRacingClassesResponse getRacingClasses() {
        return toResponse(racingClassService.findAll());
    }

    @GetMapping("/racing-classes/{classId}")
    public GetRacingClassResponse getRacingClass(@PathVariable UUID classId) {
        Optional<RacingClass> optionalRacingClass = racingClassService.find(classId);
        if (optionalRacingClass.isPresent()) {
            RacingClass racingClass = optionalRacingClass.get();
            return toResponse(racingClass);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/racing-classes/{classId}")
    public ResponseEntity<Void> putRacingClass(@PathVariable UUID classId, @RequestBody PutRacingClassRequest request) {
        Optional<RacingClass> optional = racingClassService.find(classId);

        boolean exists = racingClassService.find(classId).isPresent();

        if (request.name() == null || request.maxHorsepower() == null || request.minWeight() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        RacingClass racingClass = RacingClass.builder()
                .id(classId)
                .name(request.name())
                .maxHorsepower(request.maxHorsepower())
                .minWeight(request.minWeight())
                .build();

        // check whether to create or update
        if (exists) {
            racingClassService.save(racingClass);
            return ResponseEntity.noContent().build();  // 204
        }
        else {
            racingClassService.create(racingClass);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
        }
    }

    @DeleteMapping("/racing-classes/{classId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRacingClass(@PathVariable UUID classId) {
        Optional<RacingClass> optional = racingClassService.find(classId);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        racingClassService.delete(classId);
    }

    // ===== Mapping entity -> DTO =====
    private GetRacingClassResponse toResponse(RacingClass racingClass) {
        return new GetRacingClassResponse(
            racingClass.getId(),
            racingClass.getName(),
            racingClass.getMaxHorsepower(),
            racingClass.getMinWeight()
        );
    }

    private GetRacingClassesResponse toResponse(List<RacingClass> classes) {
        return new GetRacingClassesResponse(classes.stream()
                .map(racingClass -> new GetRacingClassesResponse.Entry(racingClass.getId(), racingClass.getName()))
                .toList());
    }
}
