package com.jbugs.project.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class ClassNotice {
    @Id
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

    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
