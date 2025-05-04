package com.ecom.userservice.services;


import com.ecom.userservice.dtos.request.EComUserRequestDto;
import com.ecom.userservice.dtos.response.AddressResponsetDto;
import com.ecom.userservice.dtos.response.EComUserResponseDto;
import com.ecom.userservice.entities.Address;
import com.ecom.userservice.entities.EComUser;
import com.ecom.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<EComUserResponseDto> getUsers() {
        return userRepository.findAll().stream()
                .map(this::mapResponseToEntity)
                .collect(Collectors.toList());
    }

    public EComUserResponseDto getUser(String id) {

        return userRepository.findById(String.valueOf(id)).map(this::mapResponseToEntity).orElse(null);


    }

    public void createUser(EComUserRequestDto requestDto) {
        EComUser eComUser = new EComUser();
        convertRequestTOEntity(eComUser, requestDto);
        userRepository.save(eComUser);
    }


    public boolean updateUser(Long id, EComUserRequestDto requestDto) {
        return userRepository.findById(String.valueOf(id))
                .map(existingUser -> {
                    convertRequestTOEntity(existingUser, requestDto);
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }

    public String deleteUser(String id) {
        if (userRepository.existsById(String.valueOf(id))) {
            userRepository.deleteById(String.valueOf(id));
            return "User deleted successfully";
        }
        return "User not found";
    }

    private void convertRequestTOEntity(EComUser eComUser, EComUserRequestDto requestDto) {
        eComUser.setFirstName(requestDto.getFirstName());
        eComUser.setLastName(requestDto.getLastName());
        eComUser.setEmail(requestDto.getEmail());
        eComUser.setPhoneNumber(requestDto.getPhoneNumber());
        if (requestDto.getAddressRequestDto() != null) {
            Address address = new Address();
            address.setStreet(requestDto.getAddressRequestDto().getStreet());
            address.setCity(requestDto.getAddressRequestDto().getCity());
            address.setCountry(requestDto.getAddressRequestDto().getCountry());
            address.setZip(requestDto.getAddressRequestDto().getZip());
            address.setState(requestDto.getAddressRequestDto().getState());
            eComUser.setAddress(address);
        }

    }

    private EComUserResponseDto mapResponseToEntity(EComUser eComUser) {
        EComUserResponseDto eComUserResponseDto = new EComUserResponseDto();
        eComUserResponseDto.setId(String.valueOf(eComUser.getId()));
        eComUserResponseDto.setFirstName(eComUser.getFirstName());
        eComUserResponseDto.setLastName(eComUser.getLastName());
        eComUserResponseDto.setEmail(eComUser.getEmail());
        eComUserResponseDto.setPhoneNumber(eComUser.getPhoneNumber());
        eComUserResponseDto.setUserRole(eComUser.getUserRole());
        AddressResponsetDto address = new AddressResponsetDto();
        if (eComUser.getAddress() != null) {
            address.setAddressId(String.valueOf(eComUser.getAddress().getAddressId()));
            address.setStreet(eComUser.getAddress().getStreet());
            address.setCity(eComUser.getAddress().getCity());
            address.setState(eComUser.getAddress().getState());
            address.setZip(eComUser.getAddress().getZip());
            address.setCountry(eComUser.getAddress().getCountry());
            eComUserResponseDto.setAddressResponsetDto(address);
        }
        eComUserResponseDto.setCreatedAt(eComUser.getCreatedAt());
        eComUserResponseDto.setUpdatedAt(eComUser.getUpdatedAt());
        return eComUserResponseDto;
    }


}
