package com.birds.Birds.repository;

import com.birds.Birds.model.Bird;
import com.birds.Birds.model.FlightlessBird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightlessBirdRepository extends JpaRepository<FlightlessBird, Long> {
}
