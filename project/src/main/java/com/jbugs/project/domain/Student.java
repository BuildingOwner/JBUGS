package com.jbugs.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue
    @Column(name = "studen_id")
    private Long id;
    private String name;
    private String track1;
    private String track2;
    private String doubleMajor;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "takes_id")
    private Takes takes;



    @OneToMany(mappedBy = "student")
    private List<Calendar>calendars = new ArrayList<>();
    public Student(Long id, String name, String track1, String track2) {
        this.id = id;
        this.name = name;
        this.track1 = track1;
        this.track2 = track2;
    }
    public Student(Long id, String name, String track1, String track2, String doubleMajor) {
        this.id = id;
        this.name = name;
        this.track1 = track1;
        this.track2 = track2;
        this.doubleMajor = doubleMajor;
    }

}
