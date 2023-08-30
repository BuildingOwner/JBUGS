package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TestScore {
    @Id
    @GeneratedValue
    @Column(name = "test_score_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;


}
