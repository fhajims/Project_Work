package com.birds.Birds.request;

import jakarta.persistence.Column;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RaptorRequest extends BirdRequest {

    @NotBlank
    private double talonLength;
    @NotBlank
    private String nestingHabitat;
    @NotBlank
    private String huntingStyle;

}
