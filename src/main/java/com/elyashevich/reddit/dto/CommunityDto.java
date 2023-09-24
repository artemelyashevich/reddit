package com.elyashevich.reddit.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CommunityDto(
        String id,
        @NotEmpty(message = "Title should not be empty")
        @Size(min = 2, message = "Minimum title length is 2 characters")
        String title,
        @NotEmpty(message = "Description should not be empty")
        @Size(min = 2, message = "Minimum description length is 2 characters")
        String description,
        @NotEmpty(message = "Creator id should not be empty")
        String creatorId
) {}
