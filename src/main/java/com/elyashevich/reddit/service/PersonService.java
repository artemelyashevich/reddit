package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.PersonSignUpDto;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.model.Post;

import java.util.List;

public interface PersonService {
    Person create(PersonSignUpDto personDto);
    List<Person> findAll();
    Person findOne(String username);
}