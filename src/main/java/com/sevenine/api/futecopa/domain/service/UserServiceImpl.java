package com.sevenine.api.futecopa.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.domain.model.*;
import com.sevenine.api.futecopa.domain.port.rest.UserRest;
import com.sevenine.api.futecopa.domain.port.service.UserService;
import com.sevenine.api.futecopa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRest userRest;

    private final UserRepository repository;

    private final ObjectMapper mapper;

    @Override
    public User register(Register register) {
        Registered registered = userRest.register(register);

        UserData userData = UserMapper.INSTANCE.toUserData(register, registered);

        return UserMapper.INSTANCE.toUser(repository.save(userData));
    }

    @Override
    public User login(Login login) {
        Logon logon = userRest.login(login);

        return UserMapper.INSTANCE.toUser(repository.findByUid(logon.getLocalId()));
    }

    @Override
    public User findByUid(String uid) {
        try {
            return mapper.convertValue(repository.findByUid(uid), User.class);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findBySlug(String slug) {
        try {
            return mapper.convertValue(repository.findBySlug(slug), User.class);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

}
