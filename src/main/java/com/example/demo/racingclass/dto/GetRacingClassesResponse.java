package com.example.demo.racingclass.dto;

import java.util.List;
import java.util.UUID;

public record GetRacingClassesResponse(List<Entry> racingClasses) {
    public record Entry (UUID id, String name) {}
}
