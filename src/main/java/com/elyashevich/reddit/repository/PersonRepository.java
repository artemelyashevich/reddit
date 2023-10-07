package com.elyashevich.reddit.repository;

import com.elyashevich.reddit.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    @Query("{ 'username' : ?0 }")
    List<Person> findByUsername(String username);
}
