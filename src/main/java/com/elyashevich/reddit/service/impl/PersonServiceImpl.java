package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.PersonDto;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.mapping.PersonMapping;
import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapping personMapping;

    @Override
    public Person create(PersonDto personDto) {
        log.info("CREATE PERSON");
        final Person person = personMapping.convert(personDto);
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        log.info("FIND ALL PEOPLE");
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(String id) {
        log.info("FIND PERSON BY ID");
        return personRepository.findById(id).orElseThrow(() ->
                new PersonException(String.format("Person with id = %s wasn't found!", id))
        );
    }

    @Override
    public void delete(String id) {
        log.info("DELETE PERSON");
        final Person person = getPersonById(id);
        personRepository.delete(person);
    }

    @Override
    public Person updateOne(PersonDto personDto) {
        log.info("UPDATE PERSON");
        final Person person = getPersonById(personDto.id());
        person.setUsername(personDto.username());
        person.setEmail(personDto.email());
        person.setUpdated(LocalDateTime.now());
        personRepository.save(person);
        return person;
    }
}
