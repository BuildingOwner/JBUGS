package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;

    private String week;
    private String question;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "class_id")
    private Classes classes;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "class_contents_id")
    private ClassContents classContents;

    public static Test createQuiz(Classes classes, String classContents, String question){
        Test test = new Test();
        System.out.println("도메인 "+classes+" "+classContents+" "+question);
        test.setClasses(classes);
        test.setWeek(classContents);
        test.setQuestion(question);

        return test;
    }
}
