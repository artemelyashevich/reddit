package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.PersonSignUpDto;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(final @RequestBody PersonSignUpDto personSignUpDto) {
        return personService.create(personSignUpDto);
    }

    @GetMapping("/{username}")
    public Person findByUsername(final @PathVariable String username) {
        return personService.findOne(username);
    }
}
