package com.example.demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Value("${jdbc.url}")
    private String jdbcUrl;
    // url in a format which is used to connect to a relational db from java
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Autowired
    Person person;

    @Autowired
    DBConnection dbConnection;

    Test(){
        this.logger.info("Inside test - jdbcUrl - {}", jdbcUrl);
    }

//    @Autowired
//    Person person = new Person();

    private Logger logger = LoggerFactory.getLogger(Test.class);

    @GetMapping("/test")
    public String testFunc(@RequestParam("n") String name){ // starting point for you to think on ioc

        dbConnection.setPerson(person);
        this.logger.info("Inside testFunc = jdbcUrl - {}", jdbcUrl);
//        int id = this.person.getRandomPersonId();
//        logger.info("person = {}, id = {}", this.person, id);

        return "Hello " + name;
    }
}

// sample controller - Person@4e2ddc05
// Test - Person@4bc7fbe