package com.sevenine.api.futecopa.domain.port.service;

import com.sevenine.api.futecopa.domain.model.Login;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.entities.User;

public interface UserService {

    User register(Register register);

    User login(Login login);

    default User findByUid(String uid) {
        return new User();
    }

    default User findBySlug(String slug) {
        return new User();
    }

}
