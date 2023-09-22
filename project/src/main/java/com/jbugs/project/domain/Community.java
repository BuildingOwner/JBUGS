package com.jbugs.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Community {
    @Id
    @GeneratedValue
    @Column(name = "community_id")
    private Long id;

    private String title;
    private String imgsrc;
    private String discription;
    private String people;

}
