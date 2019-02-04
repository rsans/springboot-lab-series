package com.hotelbeds.springbootlab.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address extends BaseModel {

    private String streetName;
    private String number;
    private String door;
    private String floor;
    private String zipCode;
    private String country;
    private String state;

}
