package com.linadev14.employee.service;

import com.linadev14.employee.entity.EmployeeEntity;
import com.linadev14.employee.model.Employee;
import com.linadev14.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.beans.Beans;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceInterface {

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);

        return employee;
    }

}
