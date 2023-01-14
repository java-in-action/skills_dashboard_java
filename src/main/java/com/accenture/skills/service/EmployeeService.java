package com.accenture.skills.service;

import com.accenture.skills.bean.Employee;
import com.accenture.skills.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    public Employee newEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
