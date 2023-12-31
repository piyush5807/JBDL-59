package com.example.controllers;

import com.example.dtos.UserCreateRequest;
import com.example.models.User;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public void createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) throws JsonProcessingException {
        this.userService.create(userCreateRequest);
    }

    // This is called by anyone who is a user
    @GetMapping("/details")
    public User getUserDetails(@RequestParam("userId") int userId){
        return this.userService.get(userId);
    }

    // This is called by transaction service or in future any other internal service but not a user
    @GetMapping("/mobile/{mobileId}")
    public User getUserDetails(@PathVariable("mobileId") String mobile){
        return (User) this.userService.loadUserByUsername(mobile);
    }
}
