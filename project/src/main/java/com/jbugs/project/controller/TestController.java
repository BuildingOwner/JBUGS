package com.jbugs.project.controller;

import com.jbugs.project.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

//    @PostMapping("/your-java-endpoint")
//    public ResponseEntity<String> receiveStringFromJavaScript(@RequestParam String value) {
//        // Handle the received string value here
//        System.out.println("Received value from JavaScript: " + value);
//        // You can send a response back to the JavaScript side if needed
//        return testService.join();
//    } 잠시 ㄱㄷㄱㄷㄱㄷㄱㄷㄱㄷㄱ
    

}
