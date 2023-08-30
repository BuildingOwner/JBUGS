package com.jbugs.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;


}
