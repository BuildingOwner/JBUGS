package com.jbugs.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClassController {

    //private final ClassService classService;

    @GetMapping("/coursepage")
    public String createForm(Model model){

        return "html/new-course-page";
    }

}
