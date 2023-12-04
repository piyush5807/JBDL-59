package com.example.demosecuritydb.controller;

import com.example.demosecuritydb.models.DemoUser;
import com.example.demosecuritydb.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoUserService demoUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String sayHello(){                 // anyone
        return "Welcome!!!";
    }

    @GetMapping("/faculty")                   // faculty
    public String sayHelloToFaculty(){
        return "Hello faculty";
    }

    @GetMapping("/student")                    // student
    public String sayHelloToStudent(){
        return "Hello student";
    }

    @GetMapping("/library")                   // student / faculty
    public String welcomeToLibrary(){
        return "Welcome to library!!";
    }

    // sign up --> plaint text --> store corresponding encoded pwd
    // sign in --> plain text --> encoded pwd --> match with the db password

    @PostMapping("/student/signup")
    public DemoUser signup(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities("login_student::access_library")
                .build();
        return this.demoUserService.save(demoUser);
    }

//    @PostMapping("/faculty/signup") // not authenticated
//    public void signupFaculty(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password
//    ){
//        /**
//         * 1. assign authorities
//         * 2. convert plain text --> encrypted form
//         * 3. save it in the repository
//         */
//    }
}
