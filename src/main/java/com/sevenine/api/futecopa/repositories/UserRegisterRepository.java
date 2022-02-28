package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.User;

public interface UserRegisterRepository {
    void create(User newUser);
}
