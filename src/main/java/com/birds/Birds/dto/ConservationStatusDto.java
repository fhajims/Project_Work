package com.birds.Birds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConservationStatusDto {
    private Long id;
    private String status;
    private String name;
    private String description;
    private String iucnCode;
    private Integer yearAssessed;
    private String populationTrend;
    private String geographicRange;
}