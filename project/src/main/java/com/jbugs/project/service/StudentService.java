package com.jbugs.project.service;

import com.jbugs.project.domain.Student;
import com.jbugs.project.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    //회원가입
    @Transactional
    public Long join(Student student){
        validateDuplicateStudent(student);
        studentRepository.save(student);
        return student.getId();
    }

    private void validateDuplicateStudent(Student student) {
        List<Student> findStudents = studentRepository.findByName(student.getName());
        if(!findStudents.isEmpty()){
            throw new IllegalStateException("이미존재하는 회원입니다.");
        }
    }


    /**
     *전체 회원 조회
     */
    public List<Student> findMembers() {
        return studentRepository.findAll();
    }
    public Student findOne(Long memberId) {
        return studentRepository.findOne(memberId);
    }
}
