package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.TopicCreateDto;
import com.elyashevich.reddit.model.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicMapping {
    public Topic convert(TopicCreateDto topicDto) {
        return Topic.builder()
                .title(topicDto.title())
                .description(topicDto.description())
                .image(topicDto.image())
                .creatorId(topicDto.personId())
                .build();
    }
}
