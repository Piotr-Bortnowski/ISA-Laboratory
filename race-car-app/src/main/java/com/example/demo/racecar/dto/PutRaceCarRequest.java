package com.example.demo.racecar.dto;

import java.util.UUID;

public record PutRaceCarRequest(
        String modelName,
        Integer startNumber,
        Double engineDisplacement,
        Boolean hybridPowertrain
) {}