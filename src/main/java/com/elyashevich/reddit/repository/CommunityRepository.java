package com.elyashevich.reddit.repository;

import com.elyashevich.reddit.model.Community;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityRepository extends MongoRepository<Community, String> {
}
