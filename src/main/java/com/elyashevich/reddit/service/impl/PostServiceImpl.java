package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.PostDto;
import com.elyashevich.reddit.exception.PostException;
import com.elyashevich.reddit.mapping.PostMapping;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.repository.PostRepository;
import com.elyashevich.reddit.service.PersonService;
import com.elyashevich.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapping postMapping;
    private final PersonRepository personRepository;
    private final PersonService personService;

    @Override
    public Post create(final PostDto postDto,final Set<Image> images) {
        log.info("CREATE POST");
        final Person person = personService.getPersonById(postDto.personId());
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
        log.info("FIND ALL POSTS");
        return postRepository.findAll();
    }

    @Override
    public Post findById(final String id) {
        log.info("FIND POST BY ID");
        final Post post = postRepository.findById(id).orElseThrow(() ->
                new PostException(String.format("Post with id = %s wasn't found", id))
        );
        return addView(post);
    }

    @Override
    public Post updateOne(final PostDto postDto) {
        log.info("UPDATE POST");
        final Post post = findById(postDto.id());
        personService.getPersonById(postDto.personId());
        post.setTitle(postDto.title());
        post.setUpdated(LocalDateTime.now());
        post.setBody(postDto.body());
        post.setImage(post.getImage());
        return postRepository.save(post);
    }

    @Override
    public Post setRating(final String id, final PostDto postDto) {
        log.info("SET RATING POST");
        Post post = findById(id);
        post.setRating(postDto.rating());
        return postRepository.save(post);
    }

    @Override
    public void delete(final String id) {
        log.info("DELETE POST");
        final Post post = findById(id);
        postRepository.delete(post);
    }

    private Post addView(final Post post) {
        post.setViews(post.getViews() + 1);
        return postRepository.save(post);
    }
}