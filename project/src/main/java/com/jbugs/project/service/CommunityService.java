package com.jbugs.project.service;

import com.jbugs.project.domain.Community;
import com.jbugs.project.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

    public void saveCommunity(Community community){
        communityRepository.save(community);
    }

    public List<Community> findCommunity(){
        return communityRepository.findAll();
    }

    public Community findOne(Long communityId){
        return communityRepository.findOne(communityId);
    }
}
