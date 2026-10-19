package com.example.demo.initialize;

import com.example.demo.racingclass.RacingClass;
import com.example.demo.racingclass.RacingClassService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final RacingClassService racingClassService;

    public DataInitializer(RacingClassService racingClassService) {
        this.racingClassService = racingClassService;
    }

    @PostConstruct
    public void init() {

        RacingClass gt3 = RacingClass.builder()
                .id(UUID.fromString("c1a55000-0000-0000-0000-000000000001"))
                .name("GT3").maxHorsepower(550).minWeight(1280).build();
        RacingClass lmp2 = RacingClass.builder()
                .id(UUID.fromString("c1a55000-0000-0000-0000-000000000002"))
                .name("LMP2").maxHorsepower(540).minWeight(950).build();
        RacingClass hypercar = RacingClass.builder()
                .id(UUID.fromString("c1a55000-0000-0000-0000-000000000003"))
                .name("HYPERCAR").maxHorsepower(680).minWeight(1030).build();

        racingClassService.save(gt3);
        racingClassService.save(lmp2);
        racingClassService.save(hypercar);
    }
}
