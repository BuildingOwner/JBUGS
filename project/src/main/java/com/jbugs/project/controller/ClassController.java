package com.jbugs.project.controller;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping("/course")
    public String createForm(Model model){

        return "html/new-course-page";
    }

    @GetMapping("/")
    public String list(Model model){
        List<Classes> classes = classService.findClass();
        model.addAttribute("classes", classes);
        return "html/new-main-demo";
    }

}
