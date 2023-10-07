package com.elyashevich.reddit.security;

import com.elyashevich.reddit.model.Person;
import com.elyashevich.reddit.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username).get(0);
        return PersonDetails.builder()
                .username(person.getUsername())
                .password(person.getPassword())
                .build();
    }
}
