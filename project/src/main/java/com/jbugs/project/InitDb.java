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

            Video video = new Video();
            video.setVideoname("1주차 영상");
            video.setVideosrc("/video/video1.mp4");

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
            test2.setHint("order");
            em.persist(test2);

            Test test3 = new Test();
            test3.setQuestion("노드는 다음 중 어느것에 해당하는가?");
            test3.setAnswer("1");
            test3.setSelection("['데이터 값과 다른 노드 사이의 연결 고리','저장공간','인덱스','연산']");
            em.persist(test3);

            ClassContents classContents1 = new ClassContents();
            classContents1.setClassTitle(class1.getClassName());
            classContents1.setClasses(class1);
            classContents1.setHomeworkTitle("데이터 통신 1주차 과제");
            classContents1.setDeadline("2023-10-13T23:55:00");
            classContents1.setIsSummit("Y");
            em.persist(classContents1);

            ClassContents classContents2 = new ClassContents();
            classContents2.setClassTitle(class1.getClassName());
            classContents2.setClasses(class1);
            classContents2.setHomeworkTitle("데이터 통신 2주차 과제");
            classContents2.setDeadline("2023-10-10T23:55:00");
            classContents2.setIsSummit("N");
            classContents2.setFilePath("3/1/file/asd.pdf");
            classContents2.setWeek("1");
            classContents2.setFileName("asdf");
            em.persist(classContents2);

            ClassContents classContents3 = new ClassContents();
            classContents3.setClassTitle(class2.getClassName());
            classContents3.setClasses(class2);
            classContents3.setHomeworkTitle("알고리즘 1주차 과제");
            classContents3.setDeadline("2023-10-13T23:55:00");
            classContents3.setIsSummit("Y");
            em.persist(classContents3);

            ClassContents classContents4 = new ClassContents();
            classContents4.setClassTitle(class2.getClassName());
            classContents4.setClasses(class2);
            classContents4.setHomeworkTitle("알고리즘 2주차 과제");
            classContents4.setDeadline("2023-10-13T23:55:00");
            classContents4.setIsSummit("Y");
            em.persist(classContents4);

            ClassContents classContents5 = new ClassContents();
            classContents5.setClassTitle(class3.getClassName());
            classContents5.setClasses(class3);
            classContents5.setHomeworkTitle("설계패턴 1주차 과제");
            classContents5.setDeadline("2023-10-10T23:55:00");
            classContents5.setIsSummit("Y");
            em.persist(classContents5);

            ClassContents classContents6 = new ClassContents();
            classContents6.setClassTitle(class3.getClassName());
            classContents6.setClasses(class3);
            classContents6.setHomeworkTitle("설계패턴 1주차 과제");
            classContents6.setDeadline("2023-10-13T23:55:00");
            classContents6.setIsSummit("N");
            classContents6.setVideoPath("5/1/video/hw1-최재완-1971233.mp4");
            classContents6.setVideoName("qwerqwer");
            classContents6.setWeek("1");
            em.persist(classContents3);

            ClassContents classContents7 = new ClassContents();
            classContents7.setClassTitle(class4.getClassName());
            classContents7.setClasses(class4);
            classContents7.setHomeworkTitle("모바일&스마트시스템 1주차 과제");
            classContents7.setDeadline("2023-10-10T23:55:00");
            classContents7.setIsSummit("Y");
            em.persist(classContents7);

            ClassContents classContents8 = new ClassContents();
            classContents8.setClassTitle(class4.getClassName());
            classContents8.setClasses(class4);
            classContents8.setHomeworkTitle("모바일&스마트시스템 2주차 과제");
            classContents8.setDeadline("2023-10-13T23:55:00");
            classContents8.setIsSummit("N");
            em.persist(classContents8);

            ClassContents classContents9 = new ClassContents();
            classContents9.setClassTitle(class5.getClassName());
            classContents9.setClasses(class5);
            classContents9.setHomeworkTitle("고모프 1주차 과제");
            classContents9.setDeadline("2023-10-10T23:55:00");
            classContents9.setIsSummit("Y");
            em.persist(classContents9);

            ClassContents classContents10 = new ClassContents();
            classContents10.setClassTitle(class5.getClassName());
            classContents10.setClasses(class5);
            classContents10.setHomeworkTitle("고모프 2주차 과제");
            classContents10.setDeadline("2023-10-13T23:55:00");
            classContents10.setIsSummit("N");
            em.persist(classContents10);

            ClassContents classContents11 = new ClassContents();
            classContents11.setClassTitle(class6.getClassName());
            classContents11.setClasses(class6);
            classContents11.setHomeworkTitle("웹프레임워크1 1주차 과제");
            classContents11.setDeadline("2023-10-10T23:55:00");
            classContents11.setIsSummit("Y");
            em.persist(classContents11);

            ClassContents classContents12 = new ClassContents();
            classContents12.setClassTitle(class6.getClassName());
            classContents12.setClasses(class6);
            classContents12.setHomeworkTitle("웹프레임워크1 2주차 과제");
            classContents12.setDeadline("2023-10-13T23:55:00");
            classContents12.setIsSummit("N");
            em.persist(classContents12);



            Community community1 = new Community();
            community1.setTitle("자소서 특강");
            community1.setImgsrc("/img/sangsangbugi.png");
            community1.setDiscription("자기소개서 특강합니다!");
            community1.setPeople("11");
            em.persist(community1);

            Community community2 = new Community();
            community2.setTitle("직업윤리교육");
            community2.setImgsrc("/img/sangsangbugi.png");
            community2.setDiscription("직업 의식 고취를 위한 특강");
            community2.setPeople("35");
            em.persist(community2);

            Community community3 = new Community();
            community3.setTitle("천원의 아침밥 시행안내");
            community3.setImgsrc("/img/sangsangbugi.png");
            community3.setDiscription("천원의 아침밥 시행안내");
            community3.setPeople("693");
            em.persist(community3);

        }
    }

}
