package com.hotelbeds.springbootlab.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer extends BaseModel {

    private String firstName;
    private String lastName;
    private String nif;
    private LocalDate birthDate;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String notes;

}
