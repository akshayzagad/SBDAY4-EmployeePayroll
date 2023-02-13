package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.model.EmployeePayrollData;

import java.util.List;

public interface IEService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);


    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
