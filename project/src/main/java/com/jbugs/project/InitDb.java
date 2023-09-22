package com.jbugs.project;

import com.jbugs.project.domain.*;
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
            student.setTrack1("웹공학트랙");
            student.setTrack2("모바일소프트웨어트랙");
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

            Professor professor = new Professor();
            professor.setName(class1.getProf());
            professor.setLectureRoom("공학관305호");
            professor.setEmail("dwkim116@naver.com");
            professor.setLaboratory("공학관305호");
            em.persist(professor);

            Professor professor2 = new Professor();
            professor2.setName(class2.getProf());
            professor2.setLectureRoom("공학관202호");
            professor2.setEmail("hjkang@hansung.ac.kr");
            professor2.setLaboratory("연구관320호");
            em.persist(professor2);

            Professor professor3 = new Professor();
            professor3.setName(class3.getProf());
            professor3.setLectureRoom("미래관B104");
            professor3.setEmail("keejun.han@hansung.ac.kr");
            professor3.setLaboratory("연구동215호");
            em.persist(professor3);

            Professor professor4 = new Professor();
            professor4.setName(class4.getProf());
            professor4.setLectureRoom("공학관101호");
            professor4.setEmail("jmlee@hansung.ac.kr");
            professor4.setLaboratory("연구동302호");
            em.persist(professor4);

            Professor professor5 = new Professor();
            professor5.setName(class5.getProf());
            professor5.setLectureRoom("상상관306호");
            professor5.setEmail("jyheo@hansung.ac.kr");
            professor5.setLaboratory("연구관305호");
            em.persist(professor5);

            Professor professor6 = new Professor();
            professor6.setName(class6.getProf());
            professor6.setLectureRoom("공학관102호");
            professor6.setEmail("sp@hansung.ac.kr");
            professor6.setLaboratory("연구관 329호");
            em.persist(professor6);

            Test test1 = new Test();
            test1.setQuestion("LinkedList에 대한 traverse는?");
            test1.setAnswer("순회");
            em.persist(test1);

            Test test2 = new Test();
            test2.setQuestion(" _는 데이터의 구조, 특성 또는 속성의 측면을 나타냅니다.");
            test2.setAnswer(" order");
            em.persist(test2);

            ClassContents classContents1 = new ClassContents();
            classContents1.setClassTitle(class1.getClassName());
            classContents1.setHomeworkTitle("라즈베리파이 연결 동영상 제출");
            classContents1.setDeadline("2023-10-13T23:55:00");
            classContents1.setIsSummit("Y");
            em.persist(classContents1);

            ClassContents classContents2 = new ClassContents();
            classContents2.setClassTitle(class2.getClassName());
            classContents2.setHomeworkTitle("해보기 문제 결과 제출");
            classContents2.setDeadline("2023-10-10T23:55:00");
            classContents2.setIsSummit("N");
            em.persist(classContents2);

            ClassContents classContents3 = new ClassContents();
            classContents3.setClassTitle(class3.getClassName());
            classContents3.setHomeworkTitle("라즈베리파이 연결 동영상 제출");
            classContents3.setDeadline("2023-10-13T23:55:00");
            classContents3.setIsSummit("Y");
            em.persist(classContents3);
        }
    }

}
