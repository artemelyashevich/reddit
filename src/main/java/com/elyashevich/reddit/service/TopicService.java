package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.TopicDto;
import com.elyashevich.reddit.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAll();
    Topic findById(String id);
    Topic create(TopicDto topicDto);
    void delete(String id);
    Topic updateOne(TopicDto topicDto);
}
