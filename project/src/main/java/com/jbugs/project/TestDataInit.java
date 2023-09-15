package com.jbugs.project;

import com.jbugs.project.domain.User;
import com.jbugs.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;

    @PostConstruct
    public void init(){

        User user = new User();
        user.setLoginId("1971080");
        user.setPassword("1234");
        user.setName("장주찬");


        userRepository.save(user);
        userRepository.save(new User("이영재", "1234", "1971083"));
        userRepository.save(new User("김정훈", "1234", "1971092"));
        userRepository.save(new User("최재완", "1234", "1971233"));


    }
}
