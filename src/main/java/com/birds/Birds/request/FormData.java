package com.birds.Birds.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FormData {

    @NotNull
    private String species;

    @NotNull
    private String color;

    private boolean flightless;

    private String wingSpan;

    private String beakLength;

    @NotNull
    private String habitat;

    @NotNull
    private String diet;

    private int averageLifespan;

    @NotNull
    private String migrationPattern;

    @NotNull
    private String youtubeLink;

    @NotNull
    private String type;

    private int conservationStatusId;

    private String colorVariation;

    private String intelligenceLevel;

    private String vocalAbility;

    private String songType;

    private String territorialBehavior;

    private String nestingStyle;

    private String talonLength;

    private String nestingHabitat;

    private String huntingStyle;

    private MultipartFile image;



}
