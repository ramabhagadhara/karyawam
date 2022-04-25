package com.karyawan.controller;


import com.karyawan.entity.Employee;
import com.karyawan.exception.EmployeeNotFoundException;
import com.karyawan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getStudentById(@PathVariable("id") @Min(1) Long id) {
        EmployeeService employeeservice;
        Employee std = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee std){
        return employeeService.save(std);
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Employee newStd) {
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with " + id + " is Not Found!"));
        employee.setNip(newStd.getNip());
        employee.setFirstName(newStd.getFirstName());
        employee.setLastName(newStd.getLastName());
        employee.setJabatan(newStd.getJabatan());
        employee.setEmail(newStd.getEmail());
        employee.setPhone(newStd.getPhone());
        employee.setAlamat(newStd.getAlamat());
        return employeeService.save(employee);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable("id") @Min(1) Long id) {
        Employee std = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with " + id + " is Not Found!"));
        employeeService.deleteById(std.getId());
        return "Employee with ID :" + id + " is deleted";
    }
}
