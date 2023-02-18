package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.exception.EmpPayRollException;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.respository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    public List<EmployeePayrollData> employeePayrollDataArrayList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataArrayList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataArrayList.stream().
                filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId).
                findFirst()
//                   .orElseThrow(()->new IllegalArgumentException("Id Not Found"));
                .orElseThrow(()->new EmpPayRollException("ID Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = new EmployeePayrollData( empPayrollDTO);
        employeePayrollDataArrayList.add(employeePayrollData);
        log.debug("employeePayrollData: "+ employeePayrollData.toString());
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataArrayList.set(empId - 1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataArrayList.remove(empId - 1);
    }
}
