package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;
    private String mail;

    @Enumerated(EnumType.STRING)
    private UserAdmin status; //STUDENT, PROFESSOR

    @OneToOne(mappedBy = "user", fetch = LAZY)
    private Student student;

    @OneToOne(mappedBy = "user", fetch = LAZY)
    private Professor professor;


}
