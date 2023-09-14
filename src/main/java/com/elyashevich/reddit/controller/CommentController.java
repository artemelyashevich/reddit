package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.CommentCreateDto;
import com.elyashevich.reddit.model.Comment;
import com.elyashevich.reddit.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @PostMapping
    public Comment create(final @RequestBody CommentCreateDto commentDto) {
        return commentService.create(commentDto);
    }

    @GetMapping("/{id}")
    public Comment findById(final @PathVariable String id) {
        return commentService.findById(id);
    }
}
