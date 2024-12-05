package com.birds.Birds.repository;

import com.birds.Birds.model.ConservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConservationStatusRepository extends JpaRepository<ConservationStatus, Long> {
    ConservationStatus findByName(String name);
}
