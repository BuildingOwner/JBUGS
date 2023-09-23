package com.jbugs.project.controller;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.File;
import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.Video;
import com.jbugs.project.service.ClassService;
import com.jbugs.project.service.FileService;
import com.jbugs.project.service.StudentService;
import com.jbugs.project.service.VideoService;
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
    private final StudentService studentService;
    private final FileService fileService;
    private final VideoService videoService;

    @GetMapping("/")
    public String list(Model model){
        List<Classes> classes = classService.findClass();
        model.addAttribute("classes", classes);
        Student two = studentService.findOne(2L);
        model.addAttribute("userForm",two);
        return "html/new-main-demo";
    }

    @GetMapping("/lib")
    public String libList(Model model){
        List<Classes> classes = classService.findClass();
        model.addAttribute("classes", classes);
        List<File> files = fileService.findFile();
        model.addAttribute("files", files);
        List<Video> videos = videoService.findVideo();
        model.addAttribute("videos", videos);
        return "html/new-lib";
    }

    @GetMapping(value = "/classes/{classesId}/edit")
    public String classesForm(@PathVariable("classesId") Long classesId, Model model){
        Classes one = (Classes) classService.findOne(classesId);

//        ClassForm form = new ClassForm();
//        form.setId(one.getId());
//        form.setClassName(one.getClassName());
//        form.setProf(one.getProf());

        model.addAttribute("form", one);

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
