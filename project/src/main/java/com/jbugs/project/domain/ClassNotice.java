package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long noticeId;
    private String name;
    private String title;
    private String content;
    private int viewCount;
    private Date updateDate;
    private Date regDate;
    private Date deleteDate;

    public ClassNotice(long noticeId, String name, String title, String content, int viewCount, Date updateDate, Date regDate, Date deleteDate) {
        this.noticeId = noticeId;
        this.name = name;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.updateDate = updateDate;
        this.regDate = regDate;
        this.deleteDate = deleteDate;
    }

}
