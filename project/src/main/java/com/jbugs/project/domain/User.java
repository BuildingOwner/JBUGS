package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private long userId;
    private String name;
    private String password;
    private String phoneNumber;

    public User(long userId, String name, String password, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
