package com.rhconnect.collaborators.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Positive(message = "Salary must be positive")
    private Double salary;

    private UUID occupationId; // Reference to Occupation ID
    private String occupationName; // Reference to Occupation Name

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setOccupationId(UUID occupationId) {
        this.occupationId = occupationId;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }
}