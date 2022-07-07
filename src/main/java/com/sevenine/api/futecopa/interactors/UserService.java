package com.sevenine.api.futecopa.interactors;

import com.sevenine.api.futecopa.entities.Login;
import com.sevenine.api.futecopa.entities.Register;
import com.sevenine.api.futecopa.entities.User;

public interface UserService {

    default User register(Register register) {
        return new User();
    }

    default User login(Login login) {
        return new User();
    }

    default User findByUid(String uid) {
        return new User();
    }

    default User findBySlug(String slug) {
        return new User();
    }

}
