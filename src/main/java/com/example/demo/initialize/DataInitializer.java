package com.example.demo.initialize;

import com.example.demo.racecar.RaceCar;
import com.example.demo.racecar.RaceCarService;
import com.example.demo.racingclass.RacingClass;
import com.example.demo.racingclass.RacingClassService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

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
        RacingClass gt3 = racingClassService.create("GT3", 550, 1280);
        RacingClass lmp2 = racingClassService.create("LMP2", 540, 930);
        RacingClass hypercar = racingClassService.create("HYPERCAR", 680, 1030);

        // GT3
        raceCarService.create("Porsche 911 GT3 R", 92, 4.2, false, gt3);
        raceCarService.create("Ferrari 296 GT3", 55, 2.9, false, gt3);
        raceCarService.create("McLaren 720S LMGT3 Evo", 95, 4.0, false, gt3);

        // LMP2
        raceCarService.create("ORECA 07 Gibson", 34, 4.2, false, lmp2);
        raceCarService.create("ORECA 07 Gibson", 9, 4.2, false, lmp2);
        raceCarService.create("ORECA 07 Gibson", 22, 4.2, false, lmp2);

        // HYPERCAR
        raceCarService.create("Ferrari 499P", 83, 3.0, true, hypercar);
        raceCarService.create("Aston Martin Valkyrie AMR-LMH", 7, 6.5,false, hypercar);
        raceCarService.create("Cadillac V-Series.R", 2, 5.5, true, hypercar);
    }
}
