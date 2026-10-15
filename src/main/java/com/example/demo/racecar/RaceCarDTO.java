package com.example.demo.racecar;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
class RaceCarDTO implements Comparable<RaceCarDTO> {
    private String modelName;
    private int startNumber;
    private double engineDisplacement;
    private boolean hybridPowertrain;
    private String racingClassName;

    @Override
    public int compareTo(RaceCarDTO o) {
        return this.modelName.compareTo(o.modelName);
    }
}