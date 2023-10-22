package com.example.demoapis.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

    private String id; // which is given to the employee
    private String name;
    private int age;
    private Department department;
    private Address address;
    private Long createdOn;
    private Long updatedOn;

    public Employee(String id, String name, int age, Department department, Address address, Long createdOn, Long updatedOn) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.address = address;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
}
