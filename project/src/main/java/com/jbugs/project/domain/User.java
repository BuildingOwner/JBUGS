package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String loginId;

    @Enumerated(EnumType.STRING)
    private UserAdmin status; //STUDENT, PROFESSOR

    @OneToOne(mappedBy = "user", fetch = LAZY)
    private Student student;

    public User(String name, String password, String loginId) {
        this.name = name;
        this.password = password;
        this.loginId = loginId;
    }

    @OneToOne(mappedBy = "user", fetch = LAZY)
    private Professor professor;


}
