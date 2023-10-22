package com.example.demodb.service;


import com.example.demodb.dto.CreateEmployeeRequest;
import com.example.demodb.dto.UpdateEmployeeRequest;
import com.example.demodb.models.Employee;
import com.example.demodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeRequest createEmployeeRequest) throws SQLException {

        Employee employee = createEmployeeRequest.to();
        return employeeRepository.create(employee);
    }

    public Employee get(String id) {

        return employeeRepository.get(id);
    }

    public List<Employee> get() throws SQLException {
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
