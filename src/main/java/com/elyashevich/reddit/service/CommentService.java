package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.CommentCreateDto;
import com.elyashevich.reddit.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment create(CommentCreateDto commentDto);
    Comment findById(String id);
}
