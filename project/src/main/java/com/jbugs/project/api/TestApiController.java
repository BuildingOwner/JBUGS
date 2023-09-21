package com.jbugs.project.api;

import com.jbugs.project.domain.Test;
import com.jbugs.project.service.TestService;
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
public class TestApiController {
    private final TestService testService;

    @GetMapping("/api/v1/quizs")
    public List<Test> testsV1(){
        return testService.findTest();
    }

    @GetMapping("/api/v2/quizs")
    public Result testsV2(){
        List<Test> findtests = testService.findTest();
        List<TestDto> collect = findtests.stream()
                .map(t -> new TestDto(t.getQuestion(), t.getAnswer()))
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
    static class TestDto{
        private String question;
        private String answer;
        //내부에 필요한 데이터 더 추가
    }
    @PostMapping("/api/v1/quizs")
    public CreateTestResponse saveTestV1(@RequestBody @Valid Test test){
        Long id  = testService.join(test);
        return new CreateTestResponse(id);
    }

    @PostMapping("/api/v2/quizs")
    public CreateTestResponse saveTestV2(@RequestBody @Valid CreateTestRequest request){

        Test test = new Test();
        test.setQuestion(request.getQuestion());
        test.setAnswer(request.getAnswer());
        test.setSelection(request.getSelection());

        Long id = testService.join(test);
        return new CreateTestResponse(id);
    }

    @Data
    static class CreateTestRequest{
        private String question;
        private String answer;
        private String selection;
        private String hint;
    }

    @Data
    static class CreateTestResponse{
        private Long id;

        public CreateTestResponse(Long id){
            this.id = id;
        }
    }

}
