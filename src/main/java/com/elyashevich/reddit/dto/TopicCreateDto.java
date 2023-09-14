package com.elyashevich.reddit.dto;

public record TopicCreateDto(
        String title,
        String body,
        String description,
        String image,
        String personId
) {
}
