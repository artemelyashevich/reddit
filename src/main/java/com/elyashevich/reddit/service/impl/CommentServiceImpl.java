package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.CommentDto;
import com.elyashevich.reddit.exception.CommentException;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.exception.PostException;
import com.elyashevich.reddit.mapping.CommentMapping;
import com.elyashevich.reddit.model.Comment;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.repository.CommentRepository;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.repository.PostRepository;
import com.elyashevich.reddit.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PersonRepository personRepository;
    private final PostRepository postRepository;
    private final CommentMapping commentMapping;

    @Override
    public List<Comment> findAll() {
        log.info("FIND ALL COMMENTS");
        return commentRepository.findAll();
    }

    @Override
    public Comment create(final CommentDto commentDto) {
        log.info("CREATE COMMENT");
        personRepository.findById(commentDto.personId()).orElseThrow(() ->
                new PersonException(String.format("Person with id = %s wasn't found!", commentDto.personId()))
        );
        final Post post = postRepository.findById(commentDto.postId()).orElseThrow(() ->
                new PostException(String.format("Post with id = %s wasn't found!", commentDto.postId()))
        );
        final List<String> comments = post.getComments();
        final Comment comment = commentMapping.convert(commentDto);
        final Comment newComment = commentRepository.save(comment);
        comments.add(newComment.getId());
        post.setComments(comments);
        postRepository.save(post);
        return newComment;
    }

    @Override
    public Comment findById(final String id) {
        log.info("FIND COMMENT BY ID");
        return commentRepository.findById(id).orElseThrow(() ->
                new CommentException(String.format("Comment with id = %s wasn't found!", id))
        );
    }

    @Override
    public void delete(final String id) {
        log.info("DELETE COMMENT");
        final Comment comment = findById(id);
        commentRepository.delete(comment);
    }

    @Override
    public Comment update(final CommentDto commentDto) {
        log.info("UPDATE COMMENT");
        final Comment comment = findById(commentDto.id());
        comment.setBody(commentDto.body());
        comment.setUpdated(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;
    }
}
