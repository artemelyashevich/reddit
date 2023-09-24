package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.CommentDto;
import com.elyashevich.reddit.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment create(CommentDto commentDto);
    Comment findById(String id);
    void delete(String id);
    Comment update(CommentDto commentDto);
}
