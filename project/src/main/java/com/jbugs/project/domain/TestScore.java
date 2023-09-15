package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TestScore {
    @Id
    @GeneratedValue
    @Column(name = "test_score_id")
    private Long id;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;


}
