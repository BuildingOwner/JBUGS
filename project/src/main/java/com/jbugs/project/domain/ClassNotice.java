package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassNotice {
    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;
    private String name;
    private String title;
    private String content;
    private int viewCount;
    private LocalDate updateDate;
    private String writer;
    private LocalDate deleteDate;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Class aClass;

}
