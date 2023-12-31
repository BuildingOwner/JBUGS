package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassContents {
    @Id @GeneratedValue
    @Column(name = "class_contents_id")
    private Long id;
    private String week;
    private String classTitle;
    private String homeworkTitle;
    private String deadline;
    private String isSummit;
    private String description;
    private String filePath;
    private String videoPath;
    private String fileName;
    private String videoName;
    @Lob
    private byte[] videoData;

    @Lob
    private byte[] fileData;


    @OneToMany(mappedBy = "classContents", cascade = CascadeType.ALL)
    private List<File> files = new ArrayList<>();

    @OneToMany(mappedBy = "classContents", cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="class_id")
    private Classes classes;

    @OneToMany(mappedBy = "classContents", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    public void setClasses(Classes classes){
        this.classes=classes;
        classes.getClassContents().add(this);
    }

    public void addFile(File file){
        files.add(file);
        file.setClassContents(this);
    }

    public void addVideo(Video video){
        videos.add(video);
        video.setClassContents(this);
    }

    public static ClassContents createContents(Classes classes, String weeks, String title, String description, String deadline, String FilePath, String VideoPath, String fileName, String videoName){
        ClassContents classContents = new ClassContents();
        classContents.setClasses(classes);
        classContents.setWeek(weeks);
        classContents.setClassTitle(classes.getClassName());
        classContents.setHomeworkTitle(title);
        classContents.setIsSummit("N");
        classContents.setDescription(description);
        classContents.setDeadline(deadline);
        classContents.setFileName(fileName);
        classContents.setVideoName(videoName);
        classContents.setFilePath(FilePath);
        classContents.setVideoPath(VideoPath);

        return classContents;
    }
}
