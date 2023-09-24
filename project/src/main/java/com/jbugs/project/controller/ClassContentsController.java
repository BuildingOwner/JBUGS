package com.jbugs.project.controller;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import com.jbugs.project.service.ClassContentsService;
import com.jbugs.project.service.ClassService;
import com.jbugs.project.service.FileService;
import com.jbugs.project.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClassContentsController {

    private final ClassContentsService classContentsService;
    private final ClassService classService;
    private final FileService fileService;
    private final VideoService videoService;


    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/developer")
    public String creatForm(Model model){

        List<ClassContents> classContents = classContentsService.findClass();
        List<Classes> classes = classService.findClass();

        model.addAttribute("classContents", classContents);
        model.addAttribute("classes", classes);

        return "html/developer";
    }

    @PostMapping("/developer")
    public String order(@RequestParam("classes") Long classes,
                        @RequestParam("week")String week,
                        @RequestParam("video") MultipartFile videoFile,
                        @RequestParam("file") MultipartFile file,
                        @RequestParam("homeworkTitle")String homeworkTitle,
                        @RequestParam("homeworkDescription")String homeworkDescription,
                        @RequestParam("homeworkDeadline") String homeworkDeadline) throws IOException {
            String fullFilePath = fileDir + classes +"/"+ week +"/file/"+file.getOriginalFilename();
            String filePath = classes +"/"+ week +"/file/"+file.getOriginalFilename();
            String fileName= file.getOriginalFilename();
            log.info("파일 저장 fullFilePath={}", fullFilePath);
            file.transferTo(new File(fullFilePath));

            String fullVideoPath = fileDir + classes +"/"+ week +"/video/"+videoFile.getOriginalFilename();
            String videoPath =classes +"/"+ week +"/video/"+videoFile.getOriginalFilename();
            String videoName = videoFile.getOriginalFilename();
            log.info("파일 저장 fullVideoPath={}", fullVideoPath);
            videoFile.transferTo(new File(fullVideoPath));


        classContentsService.order(classes, week, homeworkTitle, homeworkDescription, homeworkDeadline,filePath, videoPath, fileName, videoName);
        System.out.println(classes+ week  +  homeworkTitle + homeworkDescription + homeworkDeadline);
        System.out.println(videoFile);
        System.out.println(file);
        return "redirect:/";
    }

}
