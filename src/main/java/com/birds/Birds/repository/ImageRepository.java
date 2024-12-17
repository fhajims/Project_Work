package com.birds.Birds.repository;

import com.birds.Birds.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<Image, Long> {
}