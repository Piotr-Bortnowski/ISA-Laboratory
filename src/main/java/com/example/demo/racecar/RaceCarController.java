package com.example.demo.racecar;

import com.example.demo.racecar.dto.GetRaceCarResponse;
import com.example.demo.racecar.dto.GetRaceCarsResponse;
import com.example.demo.racecar.dto.PutRaceCarRequest;
import com.example.demo.racingclass.RacingClass;
import com.example.demo.racingclass.RacingClassService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RaceCarController {

    private final RaceCarService raceCarService;
    private final RacingClassService racingClassService;

    public RaceCarController(RaceCarService raceCarService, RacingClassService racingClassService) {
        this.raceCarService = raceCarService;
        this.racingClassService = racingClassService;
    }

    @GetMapping("/race-cars")
    public GetRaceCarsResponse getRaceCars() {
        return toResponse(raceCarService.findAll());
    }

    @GetMapping("/racing-classes/{classId}/race-cars")
    public GetRaceCarsResponse getRacingClassCars(@PathVariable UUID classId) {
        RacingClass racingClass = racingClassService.find(classId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Optional<RacingClass> classOptional = racingClassService.find(classId);
        if (classOptional.isPresent()) {
            return toResponse(raceCarService.findAllByRacingClass(classOptional.get()));
        }
        else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/race-cars/{id}")
    public GetRaceCarResponse getRaceCar(@PathVariable UUID id) {
        Optional<RaceCar> carOptional = raceCarService.findById(id);
        if (carOptional.isPresent()) {
            return toResponse(carOptional.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/racing-classes/{classId}/race-cars/{id}")
    public ResponseEntity<Void> putRaceCar(@PathVariable UUID classId, @PathVariable UUID id,
                                           @RequestBody PutRaceCarRequest request) {
        Optional<RacingClass> classOptional = racingClassService.find(classId);
        RacingClass racingClass;
        if (classOptional.isPresent()){
            racingClass = classOptional.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (request.modelName() == null || request.startNumber() == null
                || request.hybridPowertrain() == null || request.engineDisplacement() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        boolean exists = raceCarService.findById(id).isPresent();

        RaceCar raceCar = RaceCar.builder()
                .id(id)
                .modelName(request.modelName())
                .startNumber(request.startNumber())
                .engineDisplacement(request.engineDisplacement())
                .hybridPowertrain(request.hybridPowertrain())
                .racingClass(racingClass)
                .build();
        raceCarService.save(raceCar);

        if (exists) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
        }
    }


    @DeleteMapping("/race-cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRaceCar(@PathVariable UUID id) {
        Optional<RaceCar> optionalRaceCar = raceCarService.findById(id);
        if (optionalRaceCar.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        raceCarService.delete(id);
    }

    // ===== Mapping entity -> DTO =====
    private GetRaceCarResponse toResponse(RaceCar raceCar) {
        return new GetRaceCarResponse(
                raceCar.getId(),
                raceCar.getModelName(),
                raceCar.getStartNumber(),
                raceCar.getEngineDisplacement(),
                raceCar.isHybridPowertrain(),
                new GetRaceCarResponse.RacingClass(raceCar.getRacingClass().getId(), raceCar.getRacingClass().getName())
        );
    }
    private GetRaceCarsResponse toResponse(List<RaceCar> cars) {
        return new GetRaceCarsResponse(cars.stream()
                .map(car -> new GetRaceCarsResponse.Entry(car.getId(), car.getModelName()))
                .toList());
    }
}