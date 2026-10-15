package com.example.demo.racecar;

import com.example.demo.racingclass.RacingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RaceCarRepository extends JpaRepository<RaceCar, UUID> {
    List<RaceCar> findAllByRacingClass(RacingClass racingClass);
}
