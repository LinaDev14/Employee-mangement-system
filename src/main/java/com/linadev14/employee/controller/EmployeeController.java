package com.linadev14.employee.controller;

import com.linadev14.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
}
