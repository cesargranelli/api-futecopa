package com.sevenine.api.futecopa.domain.port.service;

import com.sevenine.api.futecopa.domain.model.Login;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.model.User;

public interface UserService {

    User register(Register register);

    User login(Login login);

    User findByUid(String uid);

    User findBySlug(String slug);

}
