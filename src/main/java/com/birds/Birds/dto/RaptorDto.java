package com.birds.Birds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaptorDto {

    private Long id;

    private Double talonLength;
    private String nestingHabitat;
    private String huntingStyle;
}
