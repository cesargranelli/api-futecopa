package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Login;
import com.sevenine.api.futecopa.application.domain.entities.Register;
import com.sevenine.api.futecopa.application.domain.entities.User;
import com.sevenine.api.futecopa.application.domain.ports.persistence.UserPersistence;
import com.sevenine.api.futecopa.application.usecases.UserPersistenceFindBySlug;
import com.sevenine.api.futecopa.application.usecases.UserPersistenceFindByUid;
import com.sevenine.api.futecopa.application.usecases.UserPersistenceLogin;
import com.sevenine.api.futecopa.application.usecases.UserPersistenceRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final List<UserPersistence<Object, User>> persistences;

    @PostMapping("register")
    public User register(@RequestBody Register register) {
        return persistences.stream().filter(object -> object instanceof UserPersistenceRegister).findAny().orElseThrow()
                .execute(register);
    }

    @PostMapping("login")
    public User login(@RequestBody Login login) {
        return persistences.stream().filter(object -> object instanceof UserPersistenceLogin).findAny().orElseThrow()
                .execute(login);
    }

    @GetMapping("uid")
    public User uid(@RequestHeader String uid) {
        return persistences.stream().filter(object -> object instanceof UserPersistenceFindByUid).findAny().orElseThrow()
                .execute(uid);
    }

    @GetMapping("slug")
    public User slug(@RequestHeader String slug) {
        return persistences.stream().filter(object -> object instanceof UserPersistenceFindBySlug).findAny().orElseThrow()
                .execute(slug);
    }

}
