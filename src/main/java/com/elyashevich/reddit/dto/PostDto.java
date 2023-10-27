package com.elyashevich.reddit.dto;

import com.elyashevich.reddit.model.Rating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PostDto(
        String id,
        @NotEmpty(message = "Title should not be empty")
        @Size(min = 2, message = "Minimum title length is 2 characters")
        String title,
        @NotEmpty(message = "Body should not be empty")
        @Size(min = 2, message = "Minimum body length is 2 characters")
        String body,
        @NotEmpty(message = "Person id should not be empty")
        String personId,
        Rating rating
) {}
