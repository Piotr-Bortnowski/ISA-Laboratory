package com.example.demo.racingclass.dto;

public record PutRacingClassRequest(
    String name,
    Integer maxHorsepower,
    Integer minWeight
) {}
