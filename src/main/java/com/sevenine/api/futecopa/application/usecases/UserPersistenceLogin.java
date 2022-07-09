package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.application.domain.entities.Login;
import com.sevenine.api.futecopa.application.domain.entities.Logon;
import com.sevenine.api.futecopa.application.domain.entities.User;
import com.sevenine.api.futecopa.application.domain.ports.persistence.UserPersistence;
import com.sevenine.api.futecopa.application.domain.ports.rest.UserRest;
import com.sevenine.api.futecopa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceLogin implements UserPersistence<Object, User> {

    private final UserRest userRest;

    private final UserRepository repository;

    @Override
    public User execute(Object login) {
        Logon logon = userRest.login((Login) login);

        UserData userData = repository.findByUid(logon.getLocalId());

        return UserMapper.INSTANCE.toUser(userData);
    }

}
