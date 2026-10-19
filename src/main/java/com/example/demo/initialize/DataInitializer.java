package com.example.demo.initialize;

import com.example.demo.racecar.RaceCar;
import com.example.demo.racecar.RaceCarService;
import com.example.demo.racingclass.RacingClass;
import com.example.demo.racingclass.RacingClassService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final RacingClassService racingClassService;
    private final RaceCarService raceCarService;

    public DataInitializer(RacingClassService racingClassService, RaceCarService raceCarService) {
        this.racingClassService = racingClassService;
        this.raceCarService = raceCarService;
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


        // GT3
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000001"))
                .modelName("Porsche 911 GT3 R").startNumber(92).engineDisplacement(4.2).hybridPowertrain(false).racingClass(gt3).
                build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000002"))
                .modelName("Ferrari 296 GT3").startNumber(55).engineDisplacement(2.9).hybridPowertrain(false).racingClass(gt3).
                build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000003"))
                .modelName("McLaren 720S LMGT3 Evo").startNumber(95).engineDisplacement(4.0).hybridPowertrain(false).racingClass(gt3).
                build());

        // LMP2
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000004"))
                .modelName("ORECA 07 Gibson").startNumber(34).engineDisplacement(4.2).hybridPowertrain(false).racingClass(lmp2)
                .build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000005"))
                .modelName("ORECA 07 Gibson").startNumber(9).engineDisplacement(4.2).hybridPowertrain(false).racingClass(lmp2)
                .build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000006"))
                .modelName("ORECA 07 Gibson").startNumber(22).engineDisplacement(4.2).hybridPowertrain(false).racingClass(lmp2)
                .build());

        // HYPERCAR
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000007"))
                .modelName("Ferrari 499P").startNumber(83).engineDisplacement(3.0).hybridPowertrain(true).racingClass(hypercar)
                .build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000008"))
                .modelName("Aston Martin Valkyrie AMR-LMH").startNumber(7).engineDisplacement(6.5).hybridPowertrain(false).racingClass(hypercar)
                .build());
        raceCarService.save(RaceCar.builder()
                .id(UUID.fromString("ca400000-0000-0000-0000-000000000009"))
                .modelName("Cadillac V-Series.R").startNumber(2).engineDisplacement(5.5).hybridPowertrain(true).racingClass(hypercar)
                .build());
    }
}
