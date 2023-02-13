package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEService{
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataArrayList=new ArrayList<>();
        employeePayrollDataArrayList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Raghav",500000)));
        return employeePayrollDataArrayList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData=new EmployeePayrollData(empId ,new EmployeePayrollDTO("Akshay",25556335));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData=new EmployeePayrollData(1,empPayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData=new EmployeePayrollData(empId,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
