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
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClassContentsService {

    private final ClassContentsRepository classContentsRepository;
    private final ClassRepository classRepository;

    @Transactional
    public Long order(Long classesId, String weeks,   String title, String description, String homeworkDeadline){
        Classes classes = classRepository.findOne(classesId);

        ClassContents contents = ClassContents.createContents(classes, weeks, title, description, homeworkDeadline);

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
