package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.PostDto;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.service.ImageService;
import com.elyashevich.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        postService.delete(id);
    }
}
