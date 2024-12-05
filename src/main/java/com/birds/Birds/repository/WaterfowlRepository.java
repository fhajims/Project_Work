package com.birds.Birds.repository;

import com.birds.Birds.model.Waterfowl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterfowlRepository extends JpaRepository<Waterfowl, Long> {
}
