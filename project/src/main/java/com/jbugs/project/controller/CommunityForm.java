package com.jbugs.project.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityForm {
    private Long id;

    private String title;
    private String imgsrc;
    private String discription;
    private String people;
}
