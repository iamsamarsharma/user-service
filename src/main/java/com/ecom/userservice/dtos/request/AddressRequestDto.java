package com.ecom.userservice.dtos.request;


import lombok.Data;

@Data
public class AddressRequestDto {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
