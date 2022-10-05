package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "city")
@Setter
@Getter
@Entity
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    private String city;
    private Integer countryId;
    private String lastUpdate;
}
