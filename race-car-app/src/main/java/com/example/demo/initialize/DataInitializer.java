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
    private RaceCarService raceCarService;

    public DataInitializer(RaceCarService raceCarService) {
        this.raceCarService = raceCarService;
    }

    @PostConstruct
    public void init() {

    }
}
