package com.jbugs.project;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.Test;
import com.jbugs.project.domain.User;
import com.jbugs.project.repository.ClassRepository;
import com.jbugs.project.repository.StudentRepository;
import com.jbugs.project.repository.UserRepository;
import com.jbugs.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;
    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;
        public void dbInit1(){
            User user = new User();
            user.setLoginId("1971080");
            user.setPassword("1234");
            user.setName("장주찬");
            em.persist(user);

            Student student = new Student();
            student.setName(user.getName());
            student.setTrack1("웹공학");
            student.setTrack2("모바일소프트웨어");
            em.persist(student);

            Classes class1 = new Classes();
            class1.setClassName("데이터통신");
            class1.setImgsrc("/img/sangsangbugi.png");
            class1.setDivision("D");
            class1.setProf("김동욱");
            em.persist(class1);

            Classes class2 = new Classes();
            class2.setClassName("알고리즘");
            class2.setImgsrc("/img/sangsangbugi.png");
            class2.setDivision("C");
            class2.setProf("강희중");
            em.persist(class2);

            Classes class3 = new Classes();
            class3.setClassName("설계패턴");
            class3.setImgsrc("/img/sangsangbugi.png");
            class3.setDivision("C");
            class3.setProf("한기준");
            em.persist(class3);

            Classes class4 = new Classes();
            class4.setClassName("모바일&스마트시스템");
            class4.setImgsrc("/img/sangsangbugi.png");
            class4.setDivision("B");
            class4.setProf("이재문");
            em.persist(class4);

            Classes class5 = new Classes();
            class5.setClassName("고급모바일프로그래밍");
            class5.setImgsrc("/img/sangsangbugi.png");
            class5.setDivision("A");
            class5.setProf("허준영");
            em.persist(class5);

            Classes class6 = new Classes();
            class6.setClassName("웹프레임워크1");
            class6.setImgsrc("/img/sangsangbugi.png");
            class6.setDivision("B");
            class6.setProf("박승현");
            em.persist(class6);
        }
    }

}
