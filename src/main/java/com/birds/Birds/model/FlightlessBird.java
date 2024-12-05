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
public class FlightlessBird extends Bird {

    @Column(name = "walking_speed")
    private Double walkingSpeed;

    @Column(name = "wing_reduction")
    private String wingReduction; // e.g., Fully Reduced, Partially Reduced

    @Column(name = "foraging_behavior")
    private String foragingBehavior;
}
