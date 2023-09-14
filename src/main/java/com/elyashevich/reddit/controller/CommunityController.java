package com.elyashevich.reddit.controller;


import com.elyashevich.reddit.dto.CommunityCreateDto;
import com.elyashevich.reddit.model.Community;
import com.elyashevich.reddit.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/communities")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public List<Community> findAll() {
        return communityService.findAll();
    }

    @PostMapping
    public Community create(final @RequestBody CommunityCreateDto communityDto) {
        return communityService.create(communityDto);
    }

    @GetMapping("/{id}")
    public Community findById(final @PathVariable String id) {
        return communityService.findById(id);
    }
}