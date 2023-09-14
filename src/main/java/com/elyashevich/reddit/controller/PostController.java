package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.PostCreateDto;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final String post = "post";

    @GetMapping
    List<Post> getAll() {
        return postService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post create(
            final @RequestPart(post) PostCreateDto postDto,
            final @RequestPart("imageFile") MultipartFile[] file
    ) throws IOException {
        final Set<Image> images = uploadImage(file);
        return postService.create(postDto, images);
    }

    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> images = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            Image image = Image.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .picByte(file.getBytes())
                    .build();
            images.add(image);
        }
        return images;
    }
}
