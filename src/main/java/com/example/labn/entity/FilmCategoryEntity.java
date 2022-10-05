package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "filmCategory")
@Setter
@Getter
@Entity
public class FilmCategoryEntity {
    @Id
    private Integer filmId;
    private Integer categoryId;
    private String lastUpdate;
}
