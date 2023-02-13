package com.example.employee_payroll.model;

import com.example.employee_payroll.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }
    public EmployeePayrollData(int employeeId, EmployeePayrollData employeePayrollData ){
        this.employeeId = employeeId;
        this.name= employeePayrollData.name;
        this.salary=employeePayrollData.salary;
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollData) {
        this.employeeId = employeeId;
        this.name= employeePayrollData.name;
        this.salary=employeePayrollData.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}


