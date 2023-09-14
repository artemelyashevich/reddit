package com.elyashevich.reddit.repository;

import com.elyashevich.reddit.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
