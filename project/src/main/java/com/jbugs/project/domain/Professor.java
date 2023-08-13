package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Professor {
    @Id @GeneratedValue
    @Column(name = "professorId")
    private Long id;
    private String name;
    private String major;

    public Professor(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

}