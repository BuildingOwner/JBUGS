package com.jbugs.project.domain;

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
public class Class {
    @Id @GeneratedValue
    @Column(name ="class_id")
    private Long id;

    private String className;
    private int year;
    private String file_name;
    private int view_count;

    @OneToMany(mappedBy = "aClass")
    private List<Takes> takes = new ArrayList<>();

    @OneToMany(mappedBy = "aClass")
    private List<Test> tests = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
