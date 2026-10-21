package com.example.demo.racingclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RacingClassRepository extends JpaRepository<RacingClass, UUID> {

}
