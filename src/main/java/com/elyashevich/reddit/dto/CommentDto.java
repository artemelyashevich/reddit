package com.elyashevich.reddit.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CommentDto(
        String id,
        @NotEmpty(message = "Body should not be empty")
        @Size(min = 2, message = "Minimum body length is 2 characters")
        String body,
        @NotEmpty(message = "Post id should not be empty")
        String postId,
        @NotEmpty(message = "Person id should not be empty")
        String personId
) {}