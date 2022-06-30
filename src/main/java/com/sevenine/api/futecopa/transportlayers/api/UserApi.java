package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.datasources.firestore.entities.User;
import com.sevenine.api.futecopa.interactors.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserApi {

    private final UserService service;

    @PostMapping("register")
    public User register(@RequestBody Map<String, String> user) {
        return service.register(user);
    }

    @PostMapping("login")
    public Object login(@RequestBody Map<String, String> login) {
        return service.login(login);
    }

    @GetMapping("uid")
    public User uid(@RequestHeader String uid) {
        return service.findByUid(uid);
    }

    @GetMapping("slug")
    public User slug(@RequestHeader String slug) {
        return service.findBySlug(slug);
    }

}
