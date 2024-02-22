package com.sanjay.loginsignup.service;

import com.sanjay.loginsignup.model.Employee;
import com.sanjay.loginsignup.model.Response;

import java.util.Map;

public interface EmployeeService{
    Map<String, Object> registration(Employee emp);
    Map<String, Object> login(Employee emp);
}
