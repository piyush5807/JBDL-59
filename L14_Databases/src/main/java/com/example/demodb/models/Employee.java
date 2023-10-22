package com.example.demodb.models;

import com.example.demodb.models.Address;
import com.example.demodb.models.Department;
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
}
