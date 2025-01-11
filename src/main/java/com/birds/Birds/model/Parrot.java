package com.birds.Birds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Parrot extends Bird {

    @Column(name = "color_variation")
    private String colorVariation;

    @Column(name = "intelligence_level")
    private String intelligenceLevel;

    @Column(name = "vocal_ability")
    private String vocalAbility;


    public Parrot(Long id, String species, String color, Boolean flightless, Double wingSpan, Double beakLength, String habitat, String diet, Integer averageLifespan, String migrationPattern, String imageUrl, String youtubeLink, String type, HashSet<Observation> observations, ConservationStatus conservationStatus, String colorVariation, String intelligenceLevel, String vocalAbility) {
        super(id, species, color, flightless, wingSpan, beakLength, habitat, diet, averageLifespan, migrationPattern, imageUrl, youtubeLink, type, observations, conservationStatus);
        this.colorVariation = colorVariation;
        this.intelligenceLevel = intelligenceLevel;
        this.vocalAbility = vocalAbility;
    }


}


