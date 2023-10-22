package com.example.demodb.dto;

import com.example.demodb.models.Address;
import com.example.demodb.models.Department;
import com.example.demodb.models.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
@ToString
@Builder
public class CreateEmployeeRequest {


    @NotBlank
    private String name;

    @Min(18)
    @Max(60) // 71 > 60
    private int age;

    @NotNull
    private Department department;

    private Address address;

    // conversion from dto --> model
    public Employee to() {

//        Employee employee = new Employee();
//        employee.setName(this.name); // returns void
//        employee.setDepartment(this.department);
//        employee.setAddress(this.address);
//        employee.setAge(this.age);
//
//        employee.setCreatedOn(System.currentTimeMillis());
//        employee.setUpdatedOn(System.currentTimeMillis());
//        employee.setId(UUID.randomUUID().toString());

        return Employee.builder() // getting the reference of employeeBuilder class
                .name(this.name) // does not return void, it returns an employeeBuilder
                .age(this.age) // calling the functions of employeeBuilder which returns an object of employeeBuilder
                .address(this.address)
                .department(this.department)
                .createdOn(System.currentTimeMillis())
                .updatedOn(System.currentTimeMillis())
                .id(UUID.randomUUID().toString())
                .build(); // again a function of employeeBuilder which is returning an instance of employee object
    }
}
