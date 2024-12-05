package com.birds.Birds.repository;

import com.birds.Birds.model.Bird;
import com.birds.Birds.model.ConservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    List<Bird> findByType(String type);
    List<Bird> findByConservationStatus(ConservationStatus status);

    List<Bird> findByFlightlessTrue();

    List<Bird> findBySpecies(String species);


}
