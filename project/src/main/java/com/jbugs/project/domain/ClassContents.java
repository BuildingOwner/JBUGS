package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassContents {
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="class_id")
    private Classes aClass;

}
