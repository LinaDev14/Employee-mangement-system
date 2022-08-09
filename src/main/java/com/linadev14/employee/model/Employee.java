package com.linadev14.employee.model;
import lombok.Data;

@Data
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String numberPhone;
    private String country;

}
