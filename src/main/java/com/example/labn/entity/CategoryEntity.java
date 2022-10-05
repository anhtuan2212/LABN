package com.example.labn.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "category")
@Entity
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    private String lastUpdate;
}
