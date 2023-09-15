package com.jbugs.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @RequestMapping("/")
    public String main(){
        log.info("main controller");
        return "html/new-main-demo";
    }

    @RequestMapping("/new-lib.html")
    public String library(){
        log.info("main controller go new-lib");
        return "html/new-lib";
    }

    @RequestMapping("/new-course-page.html")
    public String course_page(){
        log.info("main controller go course-page");
        return "html/new-course-page";
    }

    @RequestMapping("/quiz.html")
    public String quiz(){
        log.info("main controller go quiz");
        return "html/quiz";
    }
}
