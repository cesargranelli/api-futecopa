package com.sevenine.api.futecopa.transportlayers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegister {
    private String name;
    private String nickname;
    private String email;
    private String password;
}
