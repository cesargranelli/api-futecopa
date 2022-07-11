package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Register {
    private String name;
    private String nickname;
    private String email;
    private String password;
}
