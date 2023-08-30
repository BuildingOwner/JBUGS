package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;

    private Long classId;
    private int year;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @OneToOne(mappedBy = "test")
    private TestScore testScore;

    public Test(Long id, Long classId, int year) {
        this.id = id;
        this.classId = classId;
        this.year = year;
    }

}
