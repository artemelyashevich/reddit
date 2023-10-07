package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.PersonDto;
import com.elyashevich.reddit.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonMapping {
    public Person convert(PersonDto personDto) {
        return Person.builder()
                .username(personDto.username())
                .email(personDto.email())
                .password(personDto.email())
                .posts(new ArrayList<>())
                .communities(new ArrayList<>())
                .roles(new ArrayList<>())
                .build();
    }
}
