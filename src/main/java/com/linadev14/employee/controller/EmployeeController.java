package com.linadev14.employee.controller;

import com.linadev14.employee.model.Employee;
import com.linadev14.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
// ruta de proyecto de react
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // localhost:8080/api/v1/employees
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    // localhost:8080/api/v1/listEmployees
    @GetMapping("listEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
