package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.PersonSignUpDto;
import com.elyashevich.reddit.mapping.PersonMapping;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.model.Post;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapping personMapping;

    @Override
    public Person create(PersonSignUpDto personDto) {
        final Person person = personMapping.convert(personDto);
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findOne(String username) {
        return personRepository.findByUsername(username).get(0);
    }
}
