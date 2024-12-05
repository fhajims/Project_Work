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
public class Songbird extends Bird {

    @Column(name = "song_type")
    private String songType;

    @Column(name = "territorial_behavior")
    private String territorialBehavior;

    @Column(name = "nesting_style")
    private String nestingStyle;
}
