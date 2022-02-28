package com.sevenine.api.futecopa.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Login {
    @Setter
    private String email;
    @Setter
    private String password;
    private final boolean returnSecureToken = true;
}
