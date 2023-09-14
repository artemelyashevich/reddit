package com.elyashevich.reddit.dto;

public record CommentCreateDto(
        String body,
        String postId,
        String personId
) {}
