package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.PersonDto;
import com.elyashevich.reddit.model.Person;

import java.util.List;

public interface PersonService {
    Person create(PersonDto personDto);
    List<Person> findAll();
    Person getPersonById(String id);
    void delete(String id);
    Person updateOne(PersonDto personDto);
}