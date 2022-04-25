package com.karyawan.service;

import com.karyawan.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> findById(Long id);

    Optional<Employee> findByEmail(String email);

    Employee save(Employee std);

    void deleteById (Long id);
}
