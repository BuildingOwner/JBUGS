package com.jbugs.project.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassContentsForm {
    private Long id;

    private String classTitle;
    private String homeworkTitle;
    private String deadline;
    private String isSummit;
}
