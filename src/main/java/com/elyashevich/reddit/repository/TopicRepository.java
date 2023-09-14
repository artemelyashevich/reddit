package com.elyashevich.reddit.repository;

import com.elyashevich.reddit.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic, String> {
}
