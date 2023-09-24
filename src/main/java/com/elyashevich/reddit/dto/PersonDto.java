package com.elyashevich.reddit.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PersonDto(
        String id,
        @NotEmpty(message = "Username should not be empty")
        @Size(min = 2, message = "Minimum username length is 2 characters")
        String username,
        @NotEmpty(message = "Email should not be empty")
        @Email
        String email,
        @NotEmpty(message = "Password should not be empty")
        @Size(min = 5, message = "Minimum password length is 5 characters")
        String password
) {
}
