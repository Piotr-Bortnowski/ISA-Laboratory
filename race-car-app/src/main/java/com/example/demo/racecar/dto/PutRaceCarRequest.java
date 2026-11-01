package com.example.demo.racecar.dto;


public record PutRaceCarRequest(
        String modelName,
        Integer startNumber,
        Double engineDisplacement,
        Boolean hybridPowertrain
) {}