package com.sanjay.loginsignup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String organazation;
    private String emailId;
    private String password;
    private String contactNo;

}
