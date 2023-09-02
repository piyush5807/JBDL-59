package org.example;

public class Person {

    private int id;

    private String name;

    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        if(age < 0 ){
            return;
        }

        this.age = age;
    }
}
