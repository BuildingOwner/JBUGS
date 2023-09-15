package com.jbugs.project.domain;

import com.jbugs.project.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(value = true)
    public void testUser() throws Exception {
        //given
        User user = new User();
        user.setName("최재완");


//        //when
//        Long saveId = userRepository.save(user);
//        User findUser = userRepository.findById(saveId);

//        //then
//        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
//        Assertions.assertThat(findUser.getName()).isEqualTo(user.getName());

    }

}