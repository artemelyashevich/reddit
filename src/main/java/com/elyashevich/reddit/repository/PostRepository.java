package com.elyashevich.reddit.repository;

import com.elyashevich.reddit.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {}
