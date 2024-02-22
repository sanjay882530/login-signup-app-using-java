package com.sanjay.loginsignup.controller;

import com.sanjay.loginsignup.model.Employee;
import com.sanjay.loginsignup.model.Response;
import com.sanjay.loginsignup.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class MyController {
    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public String greatingMessage() {
        return "Welcome to myApplication";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee emp) {
        return new ResponseEntity<>(service.login(emp), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registration(@RequestBody Employee emp) {
       return new ResponseEntity<>(service.registration(emp), HttpStatus.OK);
    }
}
