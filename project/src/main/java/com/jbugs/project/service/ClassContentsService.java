package com.jbugs.project.service;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.File;
import com.jbugs.project.domain.Video;
import com.jbugs.project.repository.ClassContentsRepository;
import com.jbugs.project.repository.ClassRepository;
import com.jbugs.project.repository.FileRepository;
import com.jbugs.project.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClassContentsService {

    private final ClassContentsRepository classContentsRepository;
    private final ClassRepository classRepository;
    private final FileRepository fileRepository;
    private final VideoRepository videoRepository;

    @Transactional
    public Long order(Long classesId, Long fileId, Long videoId){
        Classes classes = classRepository.findOne(classesId);
        File file = fileRepository.findOne(fileId);
        Video video = videoRepository.findOne(videoId);

        ClassContents contents = ClassContents.createContents(classes, video, file);

        classContentsRepository.save(contents);

        return contents.getId();
    }

    public void saveClassContents(ClassContents classContents){
        classContentsRepository.save(classContents);
    }

    public List<ClassContents> findClass(){
        return classContentsRepository.findAll();
    }

    public ClassContents findOne(Long classContentId){
        return classContentsRepository.findOne(classContentId);
    }
}
