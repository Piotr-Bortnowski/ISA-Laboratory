package com.example.demo.racecar.dto;

import java.util.UUID;

public record GetRaceCarResponse(
        UUID id,
        String modelName,
        int startNumber,
        double engineDisplacement,
        boolean hybridPowertrain,
        RacingClass racingClass
) {
    public record RacingClass(UUID id, String name) {}
}