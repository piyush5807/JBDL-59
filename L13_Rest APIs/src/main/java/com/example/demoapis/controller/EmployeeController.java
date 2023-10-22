package com.example.demoapis.controller;

import com.example.demoapis.dto.CreateEmployeeRequest;
import com.example.demoapis.dto.UpdateEmployeeRequest;
import com.example.demoapis.models.Employee;
import com.example.demoapis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    /**
     * Employee Management
     * CRUD APIs -
     * 1. create
     * 2. read - employee id --> employee
     * 3. update
     * 4. delete
     */

    /**
     * Input - query params (params which are added as an extra parameter after the path)
     *       - path variable (param which is added in the path itself)
     *       - request body (accepts json data: json - key value pair)
     *
     */

    /**
     * MVC architecture:
     * Controller --> Service --> Repository -- (Data layer / Model)
     */

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody @Valid CreateEmployeeRequest request){
        return employeeService.create(request);
    }

    // Getting an employee given an employeeId
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") String id){
        return employeeService.get(id);
    }

    // Getting all the employees

    @GetMapping("/employee/all")
    public List<Employee> getEmployees(){
        return employeeService.get();
    }

    // Diff b/w Put and Patch
    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") String employeeId,
                                   @RequestBody @Valid UpdateEmployeeRequest request){
        return employeeService.update(employeeId, request);
    }

//    Dont define similar APIs in the server
//    @PutMapping("/employee/{id}")
//    public Employee updateEmployee2(@RequestParam("employeeId") String employeeId,
//                                   @RequestBody UpdateEmployeeRequest request){
//        return employeeService.update(employeeId, request);
//    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") String employeeId){
        return employeeService.delete(employeeId);
    }

    // In a particular server, there should be no two similar APIs
    // Similar = Same path and same method


}
