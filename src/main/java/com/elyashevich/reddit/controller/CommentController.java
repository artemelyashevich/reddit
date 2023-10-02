package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.CommentDto;
import com.elyashevich.reddit.model.Comment;
import com.elyashevich.reddit.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(final @RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment update(final @RequestBody CommentDto commentDto) {
        return commentService.update(commentDto);
    }

    @GetMapping("/{id}")
    public Comment findById(final @PathVariable String id) {
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        commentService.delete(id);
    }
}
