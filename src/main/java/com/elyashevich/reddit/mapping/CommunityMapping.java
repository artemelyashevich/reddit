package com.elyashevich.reddit.mapping;

import com.elyashevich.reddit.dto.CommunityDto;
import com.elyashevich.reddit.model.Community;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommunityMapping {
    public Community convert(CommunityDto communityDto) {
        return Community.builder()
                .title(communityDto.title())
                .description(communityDto.description())
                .creatorId(communityDto.creatorId())
                .posts(new ArrayList<>())
                .people(new ArrayList<>())
                .build();
    }
}
