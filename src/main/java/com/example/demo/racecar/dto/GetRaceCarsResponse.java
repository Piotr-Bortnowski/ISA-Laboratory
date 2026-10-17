package com.example.demo.racecar.dto;

import java.util.List;
import java.util.UUID;

public record GetRaceCarsResponse(List<Entry> raceCars) {

    public record Entry(UUID id, String modelName) {
    }
}
