package com.example.demoapis.service;


import com.example.demoapis.dto.UpdateEmployeeRequest;
import com.example.demoapis.repository.EmployeeRepository;
import com.example.demoapis.dto.CreateEmployeeRequest;
import com.example.demoapis.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeRequest createEmployeeRequest){

        Employee employee = createEmployeeRequest.to();
        return employeeRepository.create(employee);
    }

    public Employee get(String id) {

        return employeeRepository.get(id);
    }

    public List<Employee> get(){
        return employeeRepository.get();
    }

    public Employee update(String employeeId, UpdateEmployeeRequest request) {
        Employee employee = request.to(employeeId); //

        return employeeRepository.update(employee);
    }

    public Employee delete(String employeeId) {
        return employeeRepository.delete(employeeId);
    }
}
