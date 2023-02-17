package com.example.employee_payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public @Data class EmployeePayrollDTO {
    @NotEmpty(message = "Please Enter your firstName")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}\\s{0,}$",message = "Please enter valid name")
    public String name;
    @Min(value = 500,message = "Minimum salary should be 500")
    @NotNull(message = "salary field cannot be empty")
    public long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

}
