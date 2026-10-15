package com.example.demo.racecar;

import com.example.demo.racingclass.RacingClass;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "race_cars")
public class RaceCar implements Serializable, Comparable<RaceCar> {

    @Id
    private UUID id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "start_number")
    private int startNumber;

    @Column(name = "engine_displacement")
    private double engineDisplacement;

    @Column(name = "hybrid_powertrain")
    private boolean hybridPowertrain;


    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "racing_class")
    private RacingClass racingClass;

    @Override
    public int compareTo(RaceCar o) {
        // sorted by start number
        return Integer.compare(this.startNumber, o.startNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCar raceCar = (RaceCar) o;
        return startNumber == raceCar.startNumber && Objects.equals(id, raceCar.id) && Objects.equals(modelName, raceCar.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, startNumber);
    }
}