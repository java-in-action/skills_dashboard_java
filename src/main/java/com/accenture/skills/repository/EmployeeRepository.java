package com.accenture.skills.repository;

import java.math.BigInteger;
import java.util.List;

import com.accenture.skills.bean.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, BigInteger> {

    List<Employee> findAll();

    Employee save(Employee employee);
}
