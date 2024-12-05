package com.birds.Birds.repository;

import com.birds.Birds.model.Raptor;
import com.birds.Birds.model.Songbird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongbirdRepository extends JpaRepository<Songbird, Long> {
}
