package com.example.demo.racingclass.dto;

import java.util.UUID;

public record GetRacingClassResponse (
     UUID id,
     String name,
     int maxHorsepower,
     int minWeight
) {}
