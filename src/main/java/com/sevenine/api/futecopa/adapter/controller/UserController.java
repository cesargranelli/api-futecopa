package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.domain.model.Login;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.port.service.UserService;
import com.sevenine.api.futecopa.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final UserService service;

    @PostMapping("register")
    public User register(@RequestBody Register register) {
        return service.register(register);
    }

    @PostMapping("login")
    public User login(@RequestBody Login login) {
        return service.login(login);
    }

    @GetMapping("uid")
    public Object uid(@RequestHeader String uid) {
        return service.findByUid(uid);
    }

    @GetMapping("slug")
    public Object slug(@RequestHeader String slug) {
        return service.findBySlug(slug);
    }

}
