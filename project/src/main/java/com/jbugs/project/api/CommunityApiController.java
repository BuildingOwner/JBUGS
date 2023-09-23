package com.jbugs.project.api;

import com.jbugs.project.domain.Community;
import com.jbugs.project.service.CommunityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommunityApiController {
    private final CommunityService communityService;

    @GetMapping("/api/v1/communities")
    public List<Community> communitiesV1(){
        return communityService.findCommunity();
    }

    @GetMapping("/api/v2/communities")
    public Result communitiesV2(){
        List<Community> findCommunity = communityService.findCommunity();
        List<CommunityDto> collect = findCommunity.stream()
                .map(c -> new CommunityDto(c.getTitle(), c.getImgsrc(), c.getDiscription(), c.getPeople()))
                .collect(Collectors.toList());

        return new Result(collect);

    }

    @Data
    @AllArgsConstructor
    static class Result<C>{
        private C data;
    }
    @Data
    @AllArgsConstructor
    static class CommunityDto{
        private String title;
        private String imgsrc;
        private String discription;
        private String people;
    }

    @Data
    static class CreateCommunityRequest{
        private String title;
        private String imgsrc;
        private String discription;
        private String people;
    }

    @Data
    static class CreateCommunityResponse{
        private Long id;

        public CreateCommunityResponse(Long id){
            this.id = id;
        }
    }
}
