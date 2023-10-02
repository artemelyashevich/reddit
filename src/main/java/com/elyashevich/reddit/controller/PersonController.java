package com.elyashevich.reddit.controller;

import com.elyashevich.reddit.dto.PersonDto;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.service.PersonService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
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
    public Person create(final @RequestBody PersonDto personSignUpDto) {
        return personService.create(personSignUpDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person update(final @RequestBody PersonDto personDto) {
        return personService.updateOne(personDto);
    }

    @GetMapping("/{id}")
    public Person findByUsername(final @PathVariable String id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        personService.delete(id);
    }
}
