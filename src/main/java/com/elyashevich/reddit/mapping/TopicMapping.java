package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.TopicDto;
import com.elyashevich.reddit.model.Topic;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TopicMapping {

    private static String DEFAULT_IMAGE = "some image";

    public Topic convert(TopicDto topicDto) {
        if (Objects.equals(topicDto.image(), "")) {
            DEFAULT_IMAGE = topicDto.image();
        }
        return Topic.builder()
                .title(topicDto.title())
                .description(topicDto.description())
                .image(DEFAULT_IMAGE)
                .creatorId(topicDto.personId())
                .build();
    }
}
