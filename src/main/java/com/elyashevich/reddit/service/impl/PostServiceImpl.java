package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.PostCreateDto;
import com.elyashevich.reddit.exception.PostException;
import com.elyashevich.reddit.mapping.PostMapping;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.repository.PostRepository;
import com.elyashevich.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PersonRepository personRepository;
    private final PostMapping postMapping;

    @Override
    public Post create(PostCreateDto postDto, Set<Image> images) {
        final Person person = personRepository.findByUsername(postDto.username()).get(0);
        final Post post = postMapping.convert(postDto, person.getId());
        post.setImage(images);
        final Post newPost = postRepository.save(post);
        List<String> posts = person.getPosts();
        posts.add(newPost.getId());
        person.setPosts(posts);
        personRepository.save(person);
       return newPost;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findOne(String id) {
        return postRepository.findById(id).orElseThrow(() ->
                new PostException(String.format("Post with id = %s wasn't found", id))
        );
    }

    @Override
    public void delete(String id) {
        final Post post = postRepository.findById(id).orElseThrow(() ->
                new PostException(String.format("Post with id = %s wasn't found!", id))
        );
        postRepository.delete(post);
    }
}