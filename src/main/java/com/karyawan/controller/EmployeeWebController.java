package com.karyawan.controller;

import com.karyawan.entity.Employee;
import com.karyawan.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class EmployeeWebController {
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping(value = "/create")
    public String tambahEmployee(Model model, Employee employee) {
        model.addAttribute("employee", employeeService.save(employee));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "form";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }
}
