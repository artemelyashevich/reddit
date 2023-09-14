package com.elyashevich.reddit.dto;

public record CommunityCreateDto(
        String title,
        String description,
        String creatorId
) {}
