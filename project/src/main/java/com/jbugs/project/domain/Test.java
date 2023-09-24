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

    public static Test createQuiz(Classes classes, ClassContents classContents, String question){
        Test test = new Test();
        test.setClasses(classes);
        test.setWeek(classContents.getWeek());
        test.setQuestion(question);

        return test;
    }
}
