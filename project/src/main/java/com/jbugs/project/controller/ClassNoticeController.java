package com.jbugs.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClassNoticeController {
    @GetMapping("html/library")
    public String createForm(Model model){

        return "html/library";
    }
}
