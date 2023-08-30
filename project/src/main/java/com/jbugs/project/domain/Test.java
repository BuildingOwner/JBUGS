package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;

    private int year;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @OneToOne(mappedBy = "test")
    private TestScore testScore;


}
