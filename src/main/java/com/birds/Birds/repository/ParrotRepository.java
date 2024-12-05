package com.birds.Birds.repository;

import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Parrot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParrotRepository extends JpaRepository<Parrot, Long> {
}
