package com.birds.Birds.request;

import jakarta.persistence.Column;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SongbirdRequest extends BirdRequest {

    @NotBlank
    private String songType;
    @NotBlank
    private String territorialBehavior;
    @NotBlank
    private String nestingStyle;

}
