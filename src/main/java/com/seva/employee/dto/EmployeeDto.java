package com.seva.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    private String firstname;

    @NotBlank(message = "Lastname name cannot be blank")
    private String lastname;

    @Email
    @NotBlank(message = "Email name cannot be blank")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "First name cannot be blank") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "First name cannot be blank") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "Lastname name cannot be blank") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "Lastname name cannot be blank") String lastname) {
        this.lastname = lastname;
    }

    public @Email @NotBlank(message = "Email name cannot be blank") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email name cannot be blank") String email) {
        this.email = email;
    }
}
