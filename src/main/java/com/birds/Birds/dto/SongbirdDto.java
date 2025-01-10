package com.birds.Birds.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongbirdDto {

        private Long id;
        private String species;
        private String color;
        private Boolean flightless;
        private Double wingSpan;
        private Double beakLength;
        private String habitat;
        private String diet;
        private Integer averageLifespan;
        private String migrationPattern;
        private String imageUrl;
        private String youtubeLink;
        private String type;
        private ConservationStatusDto conservationStatus;
        private String songType;
        private String territorialBehavior;
        private String nestingStyle;



}
