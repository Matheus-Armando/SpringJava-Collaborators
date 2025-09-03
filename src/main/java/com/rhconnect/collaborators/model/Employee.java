package com.rhconnect.collaborators.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Position is mandatory")
    @Column(nullable = false)
    private String position;

    @Positive(message = "Salary must be positive")
    @Column(nullable = false)
    private Double salary;

    public Long getId() {
        return id;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }
}
