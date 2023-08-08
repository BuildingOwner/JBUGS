package com.jbugs.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue
    private long studentId;
    private String name;
    private String track1;
    private String track2;
    private String doubleMajor;
    public Student(long studentId, String name, String track1, String track2) {
        this.studentId = studentId;
        this.name = name;
        this.track1 = track1;
        this.track2 = track2;
    }
    public Student(long studentId, String name, String track1, String track2, String doubleMajor) {
        this.studentId = studentId;
        this.name = name;
        this.track1 = track1;
        this.track2 = track2;
        this.doubleMajor = doubleMajor;
    }

}
