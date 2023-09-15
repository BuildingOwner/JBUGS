package com.jbugs.project.domain.login;

import com.jbugs.project.domain.User;
import com.jbugs.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String loginId, String password){
        return userRepository.findByLoginId(loginId)
                .filter(u->u.getPassword().equals(password))
                .orElse(null);
    }
}
