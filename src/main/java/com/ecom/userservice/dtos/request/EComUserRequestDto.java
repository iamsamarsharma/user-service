package com.ecom.userservice.dtos.request;

import lombok.Data;

@Data
public class EComUserRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressRequestDto addressRequestDto;
}
