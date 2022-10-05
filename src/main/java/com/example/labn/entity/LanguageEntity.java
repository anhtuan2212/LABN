package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Table(name = "language")
@Entity
@Getter
@Setter
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String languageId;
    private String name;
    private String lastUpdate;
}
