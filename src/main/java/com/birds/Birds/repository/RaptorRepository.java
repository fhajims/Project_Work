package com.birds.Birds.repository;

import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Raptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaptorRepository extends JpaRepository<Raptor, Long> {



}
