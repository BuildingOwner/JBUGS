package com.jbugs.project.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Student {
    @Id
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

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getTrack1() {
        return track1;
    }

    public String getTrack2() {
        return track2;
    }

    public String getDoubleMajor() {
        return doubleMajor;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrack1(String track1) {
        this.track1 = track1;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public void setDoubleMajor(String double_major) {
        this.doubleMajor = double_major;
    }
}
