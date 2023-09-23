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
public class Video {
    @Id @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    private String videoname;
    private String videosrc;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="class_contents_id")
    ClassContents classContents;
}
