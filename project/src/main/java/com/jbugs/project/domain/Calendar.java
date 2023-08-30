package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue
    @Column(name = "calendar_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
