package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.PostDto;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.model.Rating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostMapping {

    public Post convert(PostDto postDto, String personId) {
        return Post.builder()
                .title(postDto.title())
                .body(postDto.body())
                .views(0L)
                .creatorID(personId)
                .comments(new ArrayList<>())
                .rating(Rating.builder()
                        .negative(0L)
                        .positive(0L)
                        .build())
                .build();
    }
}
