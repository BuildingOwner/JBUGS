package com.jbugs.project.controller;

import com.jbugs.project.domain.User;
import com.jbugs.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;
//    @GetMapping("html/login")
//    public String createForm(Model model){
//        return "html/login";
//    }
//
//    @PostMapping("html/login")
//    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "html/login";
//        }
//
//        userRepository.save(user);
//        return "redirect:/";
//    }

}
