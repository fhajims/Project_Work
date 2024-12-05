package com.birds.Birds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Raptor extends Bird {

    @Column(name = "talon_length")
    private Double talonLength;

    @Column(name = "nesting_habitat")
    private String nestingHabitat;

    @Column(name = "hunting_style")
    private String huntingStyle;
}
