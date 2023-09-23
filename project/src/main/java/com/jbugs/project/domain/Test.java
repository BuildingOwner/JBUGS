package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;


    private String question;
    private String answer;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "class_id")
    private Classes classes;

    @OneToMany(mappedBy = "test")
    private List<Selection> selections;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hint_id")
    private Hint hints;

    public void addSelection(Selection selection){
        selections.add(selection);
        selection.setTest(this);
    }

    public static Test createTest(Hint hint, Selection... selections){
        Test test = new Test();
        test.setHints(hint);
        for(Selection selection : selections){
            test.addSelection(selection);
        }
        return test;
    }
}
