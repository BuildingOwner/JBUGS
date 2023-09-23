package com.jbugs.project.service;

import com.jbugs.project.domain.Community;
import com.jbugs.project.domain.Video;
import com.jbugs.project.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    public void saveVideo(Video video){
        videoRepository.save(video);
    }

    public List<Video> findVideo(){
        return videoRepository.findAll();
    }

    public Video findOne(Long videoId){
        return videoRepository.findOne(videoId);
    }
}
