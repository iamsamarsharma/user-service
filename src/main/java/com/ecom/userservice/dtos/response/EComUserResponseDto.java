package com.ecom.userservice.dtos.response;

import com.ecom.userservice.userenum.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EComUserResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserRole userRole ;
    private AddressResponsetDto addressResponsetDto;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
