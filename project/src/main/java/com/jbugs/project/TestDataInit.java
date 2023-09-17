package com.jbugs.project;

import com.jbugs.project.domain.Class;
import com.jbugs.project.domain.Professor;
import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.User;
import com.jbugs.project.repository.ClassRepository;
import com.jbugs.project.repository.StudentRepository;
import com.jbugs.project.repository.UserRepository;
import com.jbugs.project.service.ClassService;
import com.jbugs.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final ClassRepository classRepository;

    @PostConstruct
    public void init(){

        User user = new User();
        user.setLoginId("1971080");
        user.setPassword("1234");
        user.setName("장주찬");

        userRepository.save(user);
        userRepository.save(new User("이영재", "1234", "1971083"));
        userRepository.save(new User("김정훈", "1234", "1971092"));
        userRepository.save(new User("최재완", "1234", "1971233"));

        Student student = new Student();
        student.setName("장주찬");
        student.setTrack1("웹공학");
        student.setTrack2("모바일소프트웨어");
        studentRepository.save(student);

//        Class class1 = new Class();
//        class1.setClassName("데이터통신");
//        class1.setPartClass("D");
//        class1.setProf("김동욱");
//        classRepository.save(class1.getClass());


    }
}
