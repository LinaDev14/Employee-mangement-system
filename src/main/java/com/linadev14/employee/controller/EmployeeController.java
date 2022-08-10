package com.linadev14.employee.controller;

import com.linadev14.employee.model.Employee;
import com.linadev14.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // localhost:8080/api/v1/employees
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // localhost:8080/api/v1/employees/id
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;

        deleted = employeeService.deleteEmployee(id);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){

        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){

        employee = employeeService.updateEmployee(id, employee);

        return ResponseEntity.ok(employee);

    }
}
