package com.jbugs.project.controller;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping("/")
    public String list(Model model){
        List<Classes> classes = classService.findClass();
        model.addAttribute("classes", classes);
        return "html/new-main-demo";
    }

    @GetMapping(value = "/classes/{classesId}/edit")
    public String classesForm(@PathVariable("classesId") Long classesId, Model model){
        Classes one = (Classes) classService.findOne(classesId);

        ClassForm form = new ClassForm();
        form.setId(one.getId());
        form.setClassName(one.getClassName());
        form.setProf(one.getProf());

        model.addAttribute("form", form);

        return "html/new-course-page";
    }

//    @PostMapping("/course/{classesId}/edit")
//    public String classesPost(@ModelAttribute("one") ClassForm form){
//
//        Classes classes = new Classes();
//        classes.setId(form.getId());
//        classes.setClassName(form.getClassName());
//        classes.setProf(form.getProf());
//
//        classService.saveClass(classes);
//        return "re"
//    }

}
