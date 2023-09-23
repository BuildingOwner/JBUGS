package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String filename;
    private String filesrc;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="class_contents_id")
    ClassContents classContents;

}
