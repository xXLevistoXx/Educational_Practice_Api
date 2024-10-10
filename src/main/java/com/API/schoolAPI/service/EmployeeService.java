package com.API.schoolAPI.service;

import com.API.schoolAPI.model.EmployeeModel;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeModel> findAllEmployees();
    EmployeeModel findEmployeeById(UUID id);
    EmployeeModel addEmployee(EmployeeModel employee);
    EmployeeModel updateEmployee(EmployeeModel employee);
    void deleteEmployee(UUID id);
}