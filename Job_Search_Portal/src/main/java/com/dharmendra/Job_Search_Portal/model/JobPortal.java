package com.dharmendra.Job_Search_Portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class JobPortal {

    @NotNull
    @Id
    private Long id;

    @NotBlank
    private String title;

    @NotEmpty
    private String description;

    private String location;

    @Min(20000)
    private Double salary;

    @Email
    private String companyEmail;

    @NotBlank
    private String companyName;

    @NotEmpty
    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedDate;

}