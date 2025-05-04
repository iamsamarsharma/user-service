package com.ecom.userservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

}
