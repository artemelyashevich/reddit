package com.elyashevich.reddit.dto;

public record PostCreateDto(
        String title,
        String body,
        String username
) {}
