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
public class Songbird extends Bird {

    @Column(name = "song_type")
    private String songType;

    @Column(name = "territorial_behavior")
    private String territorialBehavior;

    @Column(name = "nesting_style")
    private String nestingStyle;

    public Songbird(Long id, String species, String color, Boolean flightless, Double wingSpan, Double beakLength, String habitat, String diet, Integer averageLifespan, String migrationPattern, String imageUrl, String youtubeLink, String type, HashSet<Observation> observations, ConservationStatus conservationStatus, String songType, String territorialBehavior, String nestingStyle) {
        super(id, species, color, flightless, wingSpan, beakLength, habitat, diet, averageLifespan, migrationPattern, imageUrl, youtubeLink, type, observations, conservationStatus);
        this.songType = songType;
        this.territorialBehavior = territorialBehavior;
        this.nestingStyle = nestingStyle;
    }
}
