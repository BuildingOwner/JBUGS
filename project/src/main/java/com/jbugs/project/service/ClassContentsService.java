package com.jbugs.project.service;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import com.jbugs.project.repository.ClassContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassContentsService {

    private final ClassContentsRepository classContentsRepository;

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
