package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.CommunityDto;
import com.elyashevich.reddit.exception.CommunityException;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.mapping.CommunityMapping;
import com.elyashevich.reddit.model.Community;
import com.elyashevich.reddit.repository.CommunityRepository;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final PersonRepository personRepository;
    private final CommunityMapping communityMapping;

    @Override
    public List<Community> findAll() {
        log.info("FIND ALL COMMUNITIES");
        return communityRepository.findAll();
    }

    @Override
    public Community findById(String id) {
        log.info("FIND COMMUNITY BY ID");
        return communityRepository.findById(id).orElseThrow(() ->
                new CommunityException(String.format("Community with id = %s wasn't found!", id))
        );
    }

    @Override
    public Community create(CommunityDto communityDto) {
        log.info("CREATE COMMUNITY");
        personRepository.findById(communityDto.creatorId()).orElseThrow(() ->
                new PersonException(String.format("Person with id = %s wasn't found!", communityDto.creatorId()))
        );
        final Community community = communityMapping.convert(communityDto);
        return communityRepository.save(community);
    }

    @Override
    public void delete(String id) {
        log.info("DELETE COMMUNITY");
        final Community community = findById(id);
        communityRepository.delete(community);
    }

    @Override
    public Community update(CommunityDto communityDto) {
        return null;
    }
}
