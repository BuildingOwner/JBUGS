package com.jbugs.project.api;

import com.jbugs.project.domain.Test;
import com.jbugs.project.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Test> findTests = testService.findTest();
        List<TestDto> collect = findTests.stream()
                .map(t -> new TestDto(t.getQuestion()))
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
        //내부에 필요한 데이터 더 추가
    }
//    @PostMapping("/api/v1/quizs")
//    public CreateTestResponse saveTestV1(@RequestBody @Valid Test test){
//        Long id  = testService.join(test);
//        return new CreateTestResponse(id);
//    }

//    @PostMapping("/api/v2/quizs")
//    public CreateTestResponse saveTestV2(@RequestBody @Valid CreateTestRequest request){
//
//        Test test = new Test();
//        test.setQuestion(request.getQuestion());
//
//        Long id = testService.join(test);
//        return new CreateTestResponse(id);
//    }

    @PostMapping("/api/v2/quiz")
    public ResponseEntity<String> processString(@RequestParam("classesId")Long classesId,
                                                @RequestParam("classContentsId")String classContentsId,
                                                @RequestParam("value") String receivedString) {
        // Process the receivedString as needed
        // You can save it to the database or perform any other actions

        System.out.println("컨트롤러 "+classesId+" "+classContentsId+" "+receivedString);
        testService.quizOrder(classesId,classContentsId, receivedString);

        // You can return a response if needed
        return ResponseEntity.ok("Received: " + receivedString);
    }

}
