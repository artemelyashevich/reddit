package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.TopicDto;
import com.elyashevich.reddit.model.Topic;
import com.elyashevich.reddit.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public List<Topic> findAll() {
        return topicService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topic create(final @RequestBody TopicDto topicDto) {
        return topicService.create(topicDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topic update(final @RequestBody TopicDto topicDto) {
        return topicService.updateOne(topicDto);
    }

    @GetMapping("/{id}")
    public Topic findById(final @PathVariable String id) {
        return topicService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        topicService.delete(id);
    }
}
