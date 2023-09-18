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
public class Professor {
    @Id @GeneratedValue
    @Column(name = "professor_id")
    private Long id;
    private String name;
    private String major;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "professor")
    private List<Classes> classes = new ArrayList<>();

    public Professor(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

}