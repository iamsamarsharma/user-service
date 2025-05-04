package com.ecom.userservice.entities;


import lombok.Data;

@Data
public class Address {
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

}
