package com.example.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

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
}
