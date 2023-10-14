package com.example.demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

    private Logger logger = LoggerFactory.getLogger(DBConnection.class);

    Person person;

    @Autowired
    public void setPerson(Person person){
        this.person = person;
    }

//    // jdbc:mysql://localhost:3306/dbName
////    @Value("${jdbc.url}")
//    private String jdbcUrl;
////    // url in a format which is used to connect to a relational db from java
////    @Value("${username}")
//    private String username;
////    @Value("${password}")
//    private String password;



    //    DBConnection(){
//        this.logger.info("jdbcUrl = {}, username = {}, password = {}", jdbcUrl, username, password);
//    }



    // Injecting the dependency using parameters (Way 1)

//    @Autowired
//    Person person;
//
//    DBConnection(){
//        this.logger.info("Inside DBConnection - person = {}", person);
//    }


    // Injecting the dependency using constructor (Way 2)

//    @Autowired // look like that it's parameter injection

    //    @Autowired
//    DBConnection(){
//        this.logger.info("Inside DBConnection");
//    }
//
//    @Autowired
//    DBConnection(Person person){
//        this.logger.info("Inside DBConnection - person = {}", person);
//        this.person = person; // constructor injection
//    }

//    @Autowired // redundant
//    DBConnection(Person person){
//        this.logger.info("Inside DBConnection, person - {}", person);
//    }


//    DBConnection(Person person, @Value("${jdbc.url}") String jdbcUrl){
//        this.logger.info("Inside DBConnection, person - {}, jdbcUrl - {}", person, jdbcUrl);
//    }

}
