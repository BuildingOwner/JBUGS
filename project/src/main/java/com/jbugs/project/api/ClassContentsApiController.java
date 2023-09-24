package com.jbugs.project.api;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.service.ClassContentsService;
import com.jbugs.project.service.ClassService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClassContentsApiController {

    private final ClassContentsService classContentsService;

    @GetMapping("/api/v2/homeworks")
    public Result classContentsV2(){
        List<ClassContents> findClassContents = classContentsService.findClass();
        List<ClassContentsDto> collect = findClassContents.stream()
                .map(c -> new ClassContentsDto(c.getId(), c.getClassTitle(), c.getHomeworkTitle(), c.getDeadline(), c.getIsSummit()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @GetMapping("/api/v2/course")
    public Result classFilesV2(){
        List<ClassContents> findClassContents = classContentsService.findClass();
        List<ClassFilesDto> collect = findClassContents.stream()
                .map(c -> new ClassFilesDto(c.getWeek(), c.getFilePath(), c.getFileName(), c.getVideoPath(), c.getVideoName()))
                .collect(Collectors.toList());

        return new Result(collect);

    }


    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class ClassContentsDto{
        private Long id;
        private String classTitle;
        private String homeworkTitle;
        private String deadline;
        private String isSummit;
        //내부에 필요한 데이터 더 추가
    }

    @Data
    @AllArgsConstructor
    static class ClassFilesDto{
        private String week;
        private String filePath;
        private String fileName;
        private String videoPath;
        private String videoName;
    }

//    @PostMapping("/api/v2/homeworks")
//    public CreateClassContentsResponse saveClassContentsV2(@RequestBody @Valid CreateClassContentsRequest request){
//
//
//    }

    @Data
    static class CreateClassContentsRequest{
        private String classTitle;
        private String homeworkTitle;
        private String deadline;
        private String isSummit;
    }

    @Data
    static class CreateClassContentsResponse{
        private Long id;

        public CreateClassContentsResponse(Long id){
            this.id = id;
        }
    }
}
