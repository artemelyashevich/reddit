package com.elyashevich.reddit.service;

import com.elyashevich.reddit.dto.CommunityCreateDto;
import com.elyashevich.reddit.model.Community;

import java.util.List;

public interface CommunityService {
    List<Community> findAll();
    Community findById(String id);
    Community create(CommunityCreateDto communityDto);
}
