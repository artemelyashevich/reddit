package com.elyashevich.reddit.dto;


public record PersonSignUpDto(
        String username,
        String email,
        String password
) {
}
