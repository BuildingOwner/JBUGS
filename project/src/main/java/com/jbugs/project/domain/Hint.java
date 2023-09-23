package com.jbugs.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Hint {
    @Id
    @GeneratedValue
    @Column(name = "hint_id")
    private Long id;

    private String value;

    @OneToOne(fetch = LAZY)
    private Test test;

}