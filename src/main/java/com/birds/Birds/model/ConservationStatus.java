package com.birds.Birds.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ConservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "iucn_code")
    private String iucnCode;

    @Column(name = "year_assessed")
    private Integer yearAssessed;

    @Column(name = "population_trend")
    private String populationTrend;

    @Column(name = "geographic_range")
    private String geographicRange;

    @Override
    public String toString() {
        return String.format(
                "{ \"id\": %d, \"status\": \"%s\", \"name\": \"%s\", \"description\": \"%s\", \"iucnCode\": \"%s\", \"yearAssessed\": %d, \"populationTrend\": \"%s\", \"geographicRange\": \"%s\" }",
                id,
                status,
                name,
                description,
                iucnCode,
                yearAssessed,
                populationTrend,
                geographicRange
        );
    }


}

