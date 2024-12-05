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
public class Parrot extends Bird {

    @Column(name = "color_variation")
    private String colorVariation;

    @Column(name = "intelligence_level")
    private String intelligenceLevel;

    @Column(name = "vocal_ability")
    private String vocalAbility;
}
