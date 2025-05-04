package com.ecom.userservice.controller;


import com.ecom.userservice.dtos.request.EComUserRequestDto;
import com.ecom.userservice.dtos.response.EComUserResponseDto;
import com.ecom.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<EComUserResponseDto>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<EComUserResponseDto> getUser(@PathVariable String id) {
        EComUserResponseDto EComUser = userService.getUser(id);
        if (EComUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(EComUser, HttpStatus.OK);

    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody EComUserRequestDto eComUserRequestDto) {
        userService.createUser(eComUserRequestDto);

        return ResponseEntity.ok("User created");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody EComUserRequestDto eComUserRequestDto) {
        boolean update = userService.updateUser(id, eComUserRequestDto);
        if (update) {
            return  ResponseEntity.ok("User Update");
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

}
