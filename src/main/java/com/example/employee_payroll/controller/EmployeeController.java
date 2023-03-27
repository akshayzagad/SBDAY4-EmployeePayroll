package com.example.employee_payroll.controller;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.service.IEService;
import com.example.employee_payroll.utility.Token;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
@CrossOrigin
public class EmployeeController {
    @Autowired
    IEService employeePayrollService;
    @Autowired
    Token token;

    @RequestMapping(value = {"/get"},method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getEmployeePayroollData() {
        List<EmployeePayrollData> employeePayrollDataList;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Fill The Required Filled", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{token}")
    public ResponseEntity<ResponseDTO> getEmployeePayroollDataById(@PathVariable("token") String token) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataById(token);
        ResponseDTO responseDTO = new ResponseDTO("Get call id Succsess", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroollData(@Valid
                                                                      @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.debug("Employee DTO: "+employeePayrollDTO.toString());
//        EmployeePayrollData employeePayrollData = new EmployeePayrollData();
        String tokenId ;
        tokenId = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Success", tokenId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{token}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroollData(@Valid
                                                                      @PathVariable("token") String token, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(token, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Edit Done", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroollDataById(@PathVariable("token") String token) {
        EmployeePayrollData employeePayrollData;
        employeePayrollService.deleteEmployeePayrollData(token);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id:" );
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


}
