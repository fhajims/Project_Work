package com.birds.Birds.repository;

import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
