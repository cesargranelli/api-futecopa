package com.sevenine.api.futecopa.transportlayers;

import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.repositories.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final UserQueryRepository repository;

    @GetMapping("{slug}")
    public User getUserBySlug(@PathVariable String slug) {
        return repository.findByUserWithSlug(slug);
    }

    @GetMapping("uid")
    public User getUserByUid(@RequestHeader String uid) {
        return repository.findByUserWithUid(uid);
    }

}
