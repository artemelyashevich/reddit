package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.TopicCreateDto;
import com.elyashevich.reddit.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAll();
    Topic findById(String id);
    Topic create(TopicCreateDto topicDto);
}
