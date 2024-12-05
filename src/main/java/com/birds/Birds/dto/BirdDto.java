package com.birds.Birds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BirdDto {
    private Long id;
    private String species;
    private String color;
    private Double wingSpan;
    private Double beakLength;
    private String habitat;
    private String diet;
    private Integer averageLifespan;
    private String migrationPattern;
    private String imageUrl;
    private String youtubeLink;
    private String conservationStatus;
}

