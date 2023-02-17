package com.example.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class EmployeePayrollDTO {
    @NotEmpty(message = "Please Enter your firstName")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}\\s{0,}$",message = "Please enter valid name")
    public String name;
    @Min(value = 500,message = "Minimum salary should be 500")
    @NotNull(message = "salary field cannot be empty")
    public long salary;
    public String gender;
    @JsonFormat(pattern = "dd MM yyyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;
}
