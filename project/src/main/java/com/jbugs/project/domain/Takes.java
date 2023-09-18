package com.jbugs.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Takes {

    @Id
    @GeneratedValue
    @Column(name = "takes_id")
    private Long id;

    private String progress;
    private int year;

    @OneToOne(fetch = LAZY)
    private Student student;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "class_id")
    private Classes aClass;

    /*
    * 여기에 진도 증가 검사
    *
    * */


}
