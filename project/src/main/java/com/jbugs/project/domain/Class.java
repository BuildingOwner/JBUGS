package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Class {
    @Id @GeneratedValue
    @Column(name ="classId")
    private Long id;

    private String className;
    private int year;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

    public Class(Long id, String className, int year) {
        this.id = id;
        this.className = className;
        this.year = year;
    }

}
