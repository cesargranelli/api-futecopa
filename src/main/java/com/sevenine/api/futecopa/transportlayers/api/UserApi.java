package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.entities.Login;
import com.sevenine.api.futecopa.entities.Register;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.interactors.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserApi {

    private final UserService service;

    @PostMapping("register")
    public User register(@RequestBody Register register) {
        return (User) service.register(register);
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
