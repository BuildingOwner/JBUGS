package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Classes {
    @Id @GeneratedValue
    @Column(name ="class_id")
    private Long id;

    private String className;
    private String partClass; //분반
    private int year;
    private String file_name;
    private int view_count;

    public Classes(String className, String partClass, String prof) {
        this.className = className;
        this.partClass = partClass;
        this.prof = prof;
    }

    private String prof;

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private List<Takes> takes = new ArrayList<>();

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
