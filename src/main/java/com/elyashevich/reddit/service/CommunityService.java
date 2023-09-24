package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.CommunityDto;
import com.elyashevich.reddit.model.Community;

import java.util.List;

public interface CommunityService {
    List<Community> findAll();
    Community findById(String id);
    Community create(CommunityDto communityDto);
    void delete(String id);
    Community update(CommunityDto communityDto);
}
