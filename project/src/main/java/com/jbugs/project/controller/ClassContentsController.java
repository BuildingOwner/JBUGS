package com.jbugs.project.controller;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.File;
import com.jbugs.project.domain.Video;
import com.jbugs.project.service.ClassContentsService;
import com.jbugs.project.service.ClassService;
import com.jbugs.project.service.FileService;
import com.jbugs.project.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClassContentsController {

    private final ClassContentsService classContentsService;
    private final ClassService classService;
    private final FileService fileService;
    private final VideoService videoService;

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
//                        @RequestParam("video") MultipartFile video,
//                        @RequestParam("file")MultipartFile file,
                        @RequestParam("homeworkTitle")String homeworkTitle,
                        @RequestParam("homeworkDescription")String homeworkDescription,
                        @RequestParam("homeworkDeadline") String homeworkDeadline){

        classContentsService.order(classes, week, homeworkTitle, homeworkDescription, homeworkDeadline);
        System.out.println(classes+ week  +  homeworkTitle + homeworkDescription + homeworkDeadline);
        return "redirect:/";
    }

}
