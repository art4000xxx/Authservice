package com.example.authservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
    @NotBlank(message = "User name cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}