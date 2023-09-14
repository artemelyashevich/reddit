package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.dto.CommunityCreateDto;
import com.elyashevich.reddit.exception.CommunityException;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.mapping.CommunityMapping;
import com.elyashevich.reddit.model.Community;
import com.elyashevich.reddit.repository.CommunityRepository;
import com.elyashevich.reddit.repository.PersonRepository;
import com.elyashevich.reddit.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final PersonRepository personRepository;
    private final CommunityMapping communityMapping;

    @Override
    public List<Community> findAll() {
        return communityRepository.findAll();
    }

    @Override
    public Community findById(String id) {
        return communityRepository.findById(id).orElseThrow(() ->
                new CommunityException(String.format("Community with id = %s wasn't found!", id))
        );
    }

    @Override
    public Community create(CommunityCreateDto communityDto) {
        personRepository.findById(communityDto.creatorId()).orElseThrow(() ->
                new PersonException(String.format("Person with id = %s wasn't found!", communityDto.creatorId()))
        );
        final Community community = communityMapping.convert(communityDto);
        return communityRepository.save(community);
    }
}
