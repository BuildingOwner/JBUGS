package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

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

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private List<Takes> takes = new ArrayList<>();

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
