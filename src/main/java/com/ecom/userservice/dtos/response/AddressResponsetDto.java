package com.ecom.userservice.dtos.response;

import lombok.Data;

@Data
public class AddressResponsetDto {

    private String addressId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
