package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.application.domain.entities.Register;
import com.sevenine.api.futecopa.application.domain.entities.Registered;
import com.sevenine.api.futecopa.application.domain.entities.User;
import com.sevenine.api.futecopa.application.domain.ports.persistence.UserPersistence;
import com.sevenine.api.futecopa.application.domain.ports.rest.UserRest;
import com.sevenine.api.futecopa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceRegister implements UserPersistence<Object, User> {

    private final UserRest userRest;

    private final UserRepository repository;

    @Override
    public User execute(Object register) {
        Registered registered = userRest.register((Register) register);

        UserData userData = repository.save(UserMapper.INSTANCE.toUserData((Register) register, registered));

        return UserMapper.INSTANCE.toUser(userData);
    }

}
