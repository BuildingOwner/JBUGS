package com.jbugs.project.domain.login;

import com.jbugs.project.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("html/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "html/login";
    }

    @PostMapping("html/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "html/login";
        }

        User loginUser = loginService.login(form.getLoginId(), form.getPassword());


        if(loginUser == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "html/login";
        }

        Cookie idCookie = new Cookie("userId", String.valueOf(loginUser.getId()));
        response.addCookie(idCookie);

        return "redirect:/";
    }

}
