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
public class Waterfowl extends Bird {

    @Column(name = "beak_shape")
    private String beakShape;

    @Column(name = "preferred_water_type")
    private String preferredWaterType;

    @Column(name = "migration_pattern")
    private String migrationPattern; // Could be different or more specific for waterfowl
}
