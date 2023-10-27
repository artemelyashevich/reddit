package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.PostDto;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.service.ImageService;
import com.elyashevich.reddit.service.PostService;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final ImageService imageService;
    private final static String post = "post";

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(
            final @RequestPart(post) PostDto postDto,
            final @RequestPart("imageFile") MultipartFile[] file
    ) throws IOException {
        final Set<Image> images = imageService.uploadImage(file);
        return postService.create(postDto, images);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post update(final @RequestBody PostDto postDto) {
        return postService.updateOne(postDto);
    }

    @GetMapping("/{id}")
    public Post findById(final @PathVariable String id) {
        return postService.findById(id);
    }

    @PostMapping("/{id}")
    public Post setRating(
            final @PathVariable String id,
            final @RequestBody PostDto postDto
    ) {
        return postService.setRating(id, postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        postService.delete(id);
    }
}