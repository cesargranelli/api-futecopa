package com.sevenine.api.futecopa.transportlayers;

import com.sevenine.api.futecopa.entities.UserRegistered;
import com.sevenine.api.futecopa.interactors.UserRegisterService;
import com.sevenine.api.futecopa.transportlayers.dto.UserRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "auth")
@RestController
public class AuthController {

    private final UserRegisterService userRegisterService;

    @PostMapping(value = "register")
    public UserRegistered register(@RequestBody UserRegister userRegister) {
        return userRegisterService.executar(userRegister);
    }

}
