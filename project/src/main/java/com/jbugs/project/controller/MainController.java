package com.jbugs.project.controller;

import com.jbugs.project.repository.ClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class MainController {
    @RequestMapping("/")
    public String main(){
        log.info("main controller");
        return "html/new-main-demo";
    }

    @RequestMapping("/lib")
    public String library(){
        log.info("main controller go new-lib");
        return "html/new-lib";
    }

    @RequestMapping("/course")
    public String course_page(){
        log.info("main controller go course-page");
        return "html/new-course-page";
    }

    @RequestMapping("/quiz")
    public String quiz(){
        log.info("main controller go quiz");
        return "html/quiz";
    }

}
