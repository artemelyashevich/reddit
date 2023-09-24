package com.elyashevich.reddit.controller;


import com.elyashevich.reddit.dto.CommunityDto;
import com.elyashevich.reddit.model.Community;
import com.elyashevich.reddit.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RequestMapping("/api/v1/communities")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public List<Community> findAll() {
        return communityService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Community create(final @RequestBody CommunityDto communityDto) {
        return communityService.create(communityDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Community update(final @RequestBody CommunityDto communityDto) {
        return communityService.update(communityDto);
    }

    @GetMapping("/{id}")
    public Community findById(final @PathVariable String id) {
        return communityService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        communityService.delete(id);
    }
}