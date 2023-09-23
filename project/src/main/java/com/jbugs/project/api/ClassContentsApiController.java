package com.jbugs.project.api;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.service.ClassContentsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
                .map(c -> new ClassContentsDto(c.getClassTitle(), c.getHomeworkTitle(), c.getDeadline(), c.getIsSummit()))
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
        private String classTitle;
        private String homeworkTitle;
        private String deadline;
        private String isSummit;
        //내부에 필요한 데이터 더 추가
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
