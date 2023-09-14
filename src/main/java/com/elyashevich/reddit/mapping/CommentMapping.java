package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.CommentCreateDto;
import com.elyashevich.reddit.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentMapping {
    public Comment convert(CommentCreateDto commentDto) {
        return Comment.builder()
                .body(commentDto.body())
                .creatorId(commentDto.personId())
                .postId(commentDto.postId())
                .build();
    }
}
