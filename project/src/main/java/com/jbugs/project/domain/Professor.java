package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Professor {
    @Id @GeneratedValue
    private long professorId;
    private String name;
    private String major;

    public Professor(long professorId, String name, String major) {
        this.professorId = professorId;
        this.name = name;
        this.major = major;
    }

}