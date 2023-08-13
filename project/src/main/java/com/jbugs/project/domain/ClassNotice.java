package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassNotice {
    @Id @GeneratedValue
    @Column(name = "noticeId")
    private Long id;
    private String name;
    private String title;
    private String content;
    private int viewCount;
    private Date updateDate;
    private Date regDate;
    private Date deleteDate;

    public ClassNotice(Long id, String name, String title, String content, int viewCount, Date updateDate, Date regDate, Date deleteDate) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.updateDate = updateDate;
        this.regDate = regDate;
        this.deleteDate = deleteDate;
    }

}
