package com.example.demo.racingclass;

import com.example.demo.racecar.RaceCar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "racing_classes")
public class RacingClass {
    @Id
    private UUID id;

    @Builder.Default
    @OneToMany(mappedBy = "racingClass", cascade = CascadeType.REMOVE)
    private List<RaceCar> raceCars = new ArrayList<>();
}