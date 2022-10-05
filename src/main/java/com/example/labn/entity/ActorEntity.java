package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Table(name = "actor")
@Entity
@Getter
@Setter
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer actorId;
  private String firstName;
  private String lastName;
  private String lastUpdate ;
}
