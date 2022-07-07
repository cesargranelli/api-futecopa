package com.sevenine.api.futecopa.domain.service;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.model.Registered;
import com.sevenine.api.futecopa.domain.port.rest.UserRest;
import com.sevenine.api.futecopa.domain.port.service.UserService;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements UserService {

    private final UserRest userRest;

    private final UserRepository repository;

    @Override
    public User register(Register register) {
        Registered registered = userRest.register(register);

        UserData userData = UserMapper.INSTANCE.toUserData(register, registered);

        return UserMapper.INSTANCE.toUser(repository.save(userData));
    }

}
