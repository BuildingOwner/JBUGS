package com.jbugs.project.controller;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.User;
import com.jbugs.project.repository.UserRepository;
import com.jbugs.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    @RequestMapping("/")
    public String homeLogin(@CookieValue(name = "userId", required = false) Long userId, Model model){
        log.info("main controller");
        if(userId == null){
            return "html/login";
        }

        User loginUser = userRepository.findById(userId);
        if (loginUser == null){
            return "html/login";
        }

        model.addAttribute("user", loginUser);
        return "html/new-main-demo";
    }

    @RequestMapping("/lib")
    public String library(){
        log.info("main controller go new-lib");
        return "html/new-lib";
    }

    @RequestMapping("/quiz")
    public String quiz(){
        log.info("main controller go quiz");
        return "html/quiz";
    }

    @RequestMapping("/quizHome")
    public String quizHome(){
        log.info("main controller go quizHome");
        return "html/quiz-home";
    }

    @RequestMapping("/quizScore")
    public String quizScore(){
        log.info("main controller go quizScore");
        return "html/quiz-score";
    }

    @RequestMapping("/developer")
    public String developer(){
        log.info("main controller go developer");
        return "html/developer";
    }

    @RequestMapping("/homeworks")
    public String homeworks(){
        log.info("main controller go homeworks");
        return "html/homework-page";
    }

}
