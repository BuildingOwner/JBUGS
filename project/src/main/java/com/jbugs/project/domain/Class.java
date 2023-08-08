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
public class Class {
    @Id @GeneratedValue
    private long classId;
    private String className;
    private int year;

    public Class(long classId, String className, int year) {
        this.classId = classId;
        this.className = className;
        this.year = year;
    }

}
