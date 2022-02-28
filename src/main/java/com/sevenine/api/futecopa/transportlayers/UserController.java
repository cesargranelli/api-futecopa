package com.sevenine.api.futecopa.transportlayers;

import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.repositories.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final UserQueryRepository repository;

    @GetMapping("{slug}")
    public User getUserBySlug(@PathVariable String slug) {
        return repository.findByUserWithSlug(slug);
    }

}
