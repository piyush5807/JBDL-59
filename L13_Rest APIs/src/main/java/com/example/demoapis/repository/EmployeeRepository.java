package com.example.demoapis.repository;

import com.example.demoapis.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository { // EmployeeDAO - (Data access object)

    // which ds should we use to store employee's information
    // hashmap - key (employeeId) --> value(employee)
    // list - (search will be costly ) O(N)

    private HashMap<String, Employee> employeeMap = new HashMap<>();

    public Employee create(Employee employee){
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee get(String id) {
//        return employeeMap.getOrDefault(id, null);
        return employeeMap.get(id);
    }

    public List<Employee> get(){
        return employeeMap
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    // in most of the real life scenarios, people implement patch instead of put

    public Employee update(Employee employee) {

        Employee existingEmployee = employeeMap.get(employee.getId());
        if(existingEmployee != null){
            // merge existing as well as old data
            employee = merge(existingEmployee, employee);
            employeeMap.put(employee.getId(), employee);
        }

        return employee;
    }

    // You should some library / dependency to do merging of java / json objects
    private Employee merge(Employee oldData, Employee newData){
        newData.setCreatedOn(oldData.getCreatedOn());
        return newData;
    }

    public Employee delete(String employeeId) {
        return employeeMap.remove(employeeId);
    }
}
