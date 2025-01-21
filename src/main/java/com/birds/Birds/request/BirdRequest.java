package com.birds.Birds.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;



@Data
public class BirdRequest {
    @NotBlank
    private String species;

    @NotBlank
    private String color;

    private boolean flightless;

    @NotBlank
    private String wingSpan;

    @NotBlank
    private String beakLength;

    @NotBlank
    private String habitat;

    @NotBlank
    private String diet;

    @NotBlank
    private String averageLifespan;

    @NotBlank
    private String migrationPattern;

    @NotBlank
    private String youtubeLink;

    @NotBlank
    private String type;

    private MultipartFile image;


}
