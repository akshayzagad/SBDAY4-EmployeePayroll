package com.example.employee_payroll.controller;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.service.IEService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employeepayrollservice")
public class RestController {
    @Autowired
    IEService employeePayrollService;

    @RequestMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayroollData() {
        List<EmployeePayrollData> employeePayrollDataList;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Fill The Required Filled", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayroollDataById(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get call id Succsess", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Succsess", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
//        return new  ResponseEntity<String>("Created Data Succsess : " +employeePayrollDTO , HttpStatus.OK);
    }

    @PutMapping("/edit/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroollData(@Valid @PathVariable("empID") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Edit Done", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroollDataById(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData;
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id:" + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


}
