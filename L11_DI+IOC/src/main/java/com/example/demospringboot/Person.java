package com.example.demospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Person {

//    Person(String name, int age){
//        this.age = age;
//        this.name = name;
//        this.id = new Random().nextInt(100);
//    }

    private int id; // unique key
    private String name;
    private int age;

    public Integer getRandomPersonId(){
        Random random = new Random();
        return random.nextInt();
    }

    public void name(@Value("${name}") String name){
        this.name = name;
    }


}
