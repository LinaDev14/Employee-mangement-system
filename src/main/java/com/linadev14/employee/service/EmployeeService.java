package com.linadev14.employee.service;

import com.linadev14.employee.entity.EmployeeEntity;
import com.linadev14.employee.model.Employee;
import com.linadev14.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.beans.Beans;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail(),
                        emp.getNumberPhone(),
                        emp.getCountry()
                )).toList();
    }

    @Override
    public boolean deleteEmployee(Long id) {

        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);

        return true;
    }

}
