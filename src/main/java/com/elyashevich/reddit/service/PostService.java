package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.PostDto;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Post;

import java.util.List;
import java.util.Set;

public interface PostService {
    Post create(PostDto postDto, Set<Image> images);
    List<Post> findAll();
    Post findById(String id);
    Post updateOne(PostDto postDto);
    void delete(String id);
}