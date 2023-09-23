package com.jbugs.project.controller;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.File;
import com.jbugs.project.service.ClassContentsService;
import com.jbugs.project.service.ClassService;
import com.jbugs.project.service.FileService;
import com.jbugs.project.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClassContentsController {

    private final ClassContentsService classContentsService;
    private final ClassService classService;
    private final FileService fileService;
    private final VideoService videoService;

    @GetMapping
    public String creatForm(Model model){

        List<ClassContents> classContents = classContentsService.findClass();
        List<Classes> classes = classService.findClass();

        model.addAttribute("classContents", classContents);
        model.addAttribute("classes", classes);

        return "html/developer";
    }
}
