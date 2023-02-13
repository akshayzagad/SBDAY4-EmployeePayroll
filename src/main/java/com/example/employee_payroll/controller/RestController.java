package com.example.employee_payroll.controller;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employeepayrollservice")
public class RestController {
    @RequestMapping(value = {"/get"})
    public ResponseEntity<String> getEmployeePayroollData(){
        return new ResponseEntity<String>("Get Call Succsess", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayroollDataById(@PathVariable("empId") int empId){
        return new  ResponseEntity<String>("Get Call Succsess for id : " +empId , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployeePayroollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new  ResponseEntity<String>("Created Data Succsess : " +employeePayrollDTO , HttpStatus.OK);
    }
    @PutMapping("/create")
    public ResponseEntity<String> updateEmployeePayroollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new  ResponseEntity<String>("Updated Data Succsess : " +employeePayrollDTO , HttpStatus.OK);
    }
    @DeleteMapping("/get/{empId}")
    public ResponseEntity<String> deleteEmployeePayroollDataById(@PathVariable("empId") int empId){
        return new  ResponseEntity<String>("Delete Call Succsess for id : " +empId , HttpStatus.OK);
    }


}
