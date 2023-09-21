package com.jbugs.project.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizForm {
    private Long id;

    private String question;
    private String answer;
    private String selection;
    private String hint;

}
