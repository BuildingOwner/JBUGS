package com.jbugs.project.service;

import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.Test;
import com.jbugs.project.repository.StudentRepository;
import com.jbugs.project.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    @Transactional
    public Long join(Test test){
        testRepository.save(test);
        return test.getId();
    }


    public List<Test> findTest() {
        return testRepository.findAll();
    }
    public Test findOne(Long testId) {
        return testRepository.findOne(testId);
    }
}
