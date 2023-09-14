package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.TopicCreateDto;
import com.elyashevich.reddit.model.Topic;
import com.elyashevich.reddit.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public List<Topic> findAll() {
        return topicService.findAll();
    }

    @PostMapping
    public Topic create(final @RequestBody TopicCreateDto topicDto) {
        return topicService.create(topicDto);
    }

    @GetMapping("/{id}")
    public Topic findById(final @PathVariable String id) {
        return topicService.findById(id);
    }
}
