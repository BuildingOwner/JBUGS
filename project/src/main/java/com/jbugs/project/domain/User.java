package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Professor professor;


}
