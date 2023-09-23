package com.jbugs.project.controller;

import com.jbugs.project.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/quiz/quizScore")
    public String createForm(Model model){
        model.addAttribute("form", new QuizForm());
        return "html/quizScore";
    }

    

}
