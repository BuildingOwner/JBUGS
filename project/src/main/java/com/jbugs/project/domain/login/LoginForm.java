package com.jbugs.project.domain.login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
public class LoginForm {
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
