package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.TopicDto;
import com.elyashevich.reddit.exception.TopicException;
import com.elyashevich.reddit.mapping.TopicMapping;
import com.elyashevich.reddit.model.Topic;
import com.elyashevich.reddit.repository.TopicRepository;
import com.elyashevich.reddit.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapping topicMapping;

    @Override
    public List<Topic> findAll() {
        log.info("FIND ALL TOPICS");
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(final String id) {
        log.info("FIND TOPIC BY ID");
        return topicRepository.findById(id).orElseThrow(() ->
                new TopicException(String.format("Topic with id = %s wasn't found!", id))
        );
    }

    @Override
    public Topic create(final TopicDto topicDto) {
        log.info("CREATE TOPIC");
        findById(topicDto.id());
        final Topic topic = topicMapping.convert(topicDto);
        return topicRepository.save(topic);
    }

    @Override
    public void delete(final String id) {
        log.info("DELETE TOPIC");
        final Topic topic = findById(id);
        topicRepository.delete(topic);
    }

    @Override
    public Topic updateOne(final TopicDto topicDto) {
        log.info("UPDATE TOPIC");
        final Topic topic = findById(topicDto.id());
        topic.setTitle(topicDto.title());
        topic.setBody(topicDto.body());
        topic.setImage(topicDto.image());
        return topicRepository.save(topic);
    }
}
