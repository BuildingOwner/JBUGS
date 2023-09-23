package com.jbugs.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Selection {
    @Id
    @GeneratedValue
    @Column(name = "selection_id")
    private Long id;

    private String value;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

}
