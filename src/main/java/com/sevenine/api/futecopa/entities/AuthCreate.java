package com.sevenine.api.futecopa.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCreate {
    private String email;
    private String password;
    private String displayName;
}
