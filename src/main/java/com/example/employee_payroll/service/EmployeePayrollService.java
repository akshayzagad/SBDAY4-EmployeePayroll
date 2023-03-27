package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.exception.EmpPayRollException;
import com.example.employee_payroll.jws.EmployeeSender;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.respository.EmployeePayrollRepository;
import com.example.employee_payroll.utility.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEService {
    @Autowired
    Token token1;
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    @Autowired
    EmployeeSender emailService;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(String token) {
        int userId = token1.decodeToken(token);
        System.out.println(userId);
        return employeePayrollRepository.findById(userId)
                .orElseThrow(() -> new EmpPayRollException("ID Not Found"));
    }

    @Override
    public String createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        log.debug("employeePayrollData: " + employeePayrollData);
        EmployeePayrollData employeePayrollData1 = employeePayrollRepository.save(employeePayrollData);
        String tokenId = token1.createToken(employeePayrollData1.getEmployeeId());
        emailService.sendEmail("wellcook2@gmail.com","Mail Sent",tokenId);
        return tokenId;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(String tokens, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = getEmployeePayrollDataById(tokens);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(String token) {
        EmployeePayrollData employeePayrollData = getEmployeePayrollDataById(token);
        employeePayrollRepository.delete(employeePayrollData);
    }
}
