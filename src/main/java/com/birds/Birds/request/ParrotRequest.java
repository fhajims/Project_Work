package com.birds.Birds.request;

import jakarta.persistence.Column;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ParrotRequest extends BirdRequest {

    @NotBlank
    private String colorVariation;
    @NotBlank
    private String intelligenceLevel;
    @NotBlank
    private String vocalAbility;

}
