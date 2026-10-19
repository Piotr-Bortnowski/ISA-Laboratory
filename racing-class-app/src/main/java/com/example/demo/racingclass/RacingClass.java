package com.example.demo.racingclass;

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
@Table(name = "racing_classes")
public class RacingClass implements Serializable, Comparable<RacingClass> {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_horsepower")
    private int maxHorsepower;

    @Column(name = "min_weight")
    private int minWeight;

    @Override
    public int compareTo(RacingClass o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingClass that = (RacingClass) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}