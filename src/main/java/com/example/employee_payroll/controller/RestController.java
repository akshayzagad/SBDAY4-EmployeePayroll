package com.example.employee_payroll.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/company")
    public String getAllEmployee() {
        return "Welcome To Employee PayRollApp";
    }
}
