package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Table(name = "film")
@Entity
@Setter
@Getter
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer languageId ;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Integer rentalRate;
    private Integer length;
    private Integer replacementCost;
    private String rating;
    private String specialFeatures;
    private String lastUpdate;
}
