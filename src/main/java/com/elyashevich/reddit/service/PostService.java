package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.PostCreateDto;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Post;

import java.util.List;
import java.util.Set;

public interface PostService {
    Post create(PostCreateDto postDto, Set<Image> images);
    List<Post> findAll();
    Post findOne(String id);
    void delete(String id);
}
