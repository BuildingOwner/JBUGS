package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;


    private String question;
    private String answer;
    private String selection;
    private String hint;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "class_id")
    private Classes classes;
}
