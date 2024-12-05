package com.birds.Birds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "species")
    private String species;

    @Column(name = "color")
    private String color;

    @Column(name = "flightless")
    private Boolean flightless;

    @Column(name = "wing_span")
    private Double wingSpan;

    @Column(name = "beak_length")
    private Double beakLength;

    @Column(name = "habitat")
    private String habitat;

    @Column(name = "diet")
    private String diet;

    @Column(name = "average_lifespan")
    private Integer averageLifespan;

    @Column(name = "migration_pattern")
    private String migrationPattern;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "bird", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Observation> observations;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conservation_status_id")
    private ConservationStatus conservationStatus;

}
