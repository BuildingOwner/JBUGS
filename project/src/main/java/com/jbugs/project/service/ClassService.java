package com.jbugs.project.service;


import com.jbugs.project.domain.Classes;
import com.jbugs.project.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;

    public void saveClass(Classes classes){
        classRepository.save(classes);
    }

    public List<Classes> findClass(){
        return classRepository.findAll();
    }

    public Classes findOne(Long classId){
        return classRepository.findOne(classId);
    }
}
