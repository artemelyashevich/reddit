package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.TopicCreateDto;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.exception.TopicException;
import com.elyashevich.reddit.mapping.TopicMapping;
import com.elyashevich.reddit.model.Topic;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.repository.TopicRepository;
import com.elyashevich.reddit.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final PersonRepository personRepository;
    private final TopicMapping topicMapping;

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(String id) {
        return topicRepository.findById(id).orElseThrow(() ->
                new TopicException(String.format("Topic with id = %s wasn't found!", id))
        );
    }

    @Override
    public Topic create(TopicCreateDto topicDto) {
        personRepository.findById(topicDto.personId()).orElseThrow(() ->
                new PersonException(String.format("Person with id = %s wasn't found!", topicDto.personId()))
        );
        final Topic topic = topicMapping.convert(topicDto);
        return topicRepository.save(topic);
    }
}
