package com.example.labn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "address")
@Getter
@Setter
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String address;
    private String address2;
    private String district;
    private Integer cityId;
    private String postalCode;
    private String phone;
    private String lastUpdate;
}
