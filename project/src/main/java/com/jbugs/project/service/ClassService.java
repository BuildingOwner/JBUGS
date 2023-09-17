package com.jbugs.project.service;


import com.jbugs.project.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;

    public void saveClass(Class classes){
        classRepository.save(classes);
    }

    public List<Class> findClass(){
        return classRepository.findAll();
    }

    public Class findOne(Long classId){
        return classRepository.findOne(classId);
    }
}
