package com.example.demospringsecuritynew;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String greetAdmin(){
        return "Hello Admin!!";
    }

    @GetMapping("/student")
    public String greetStudent(){
        return "Hello Admin!!";
    }

    @GetMapping("/")
    public String greet(){
        return "Hello!!";
    }
}
