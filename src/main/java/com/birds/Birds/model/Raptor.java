package com.birds.Birds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Raptor extends Bird {

    @Column(name = "talon_length")
    private Double talonLength;

    @Column(name = "nesting_habitat")
    private String nestingHabitat;

    @Column(name = "hunting_style")
    private String huntingStyle;

    public Raptor(Long id, String species, String color, Boolean flightless, Double wingSpan, Double beakLength, String habitat, String diet, Integer averageLifespan, String migrationPattern, String imageUrl, String youtubeLink, String type, HashSet<Observation> observations, HashSet<Image> images, ConservationStatus conservationStatus, Double talonLength, String nestingHabitat, String huntingStyle) {
        super(id, species, color, flightless, wingSpan, beakLength, habitat, diet, averageLifespan, migrationPattern, imageUrl, youtubeLink, type, images, observations, conservationStatus);
        this.talonLength = talonLength;
        this.nestingHabitat = nestingHabitat;
        this.huntingStyle = huntingStyle;
    }

}
