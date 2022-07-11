package com.sevenine.api.futecopa.application.usecases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.application.domain.entities.User;
import com.sevenine.api.futecopa.application.domain.ports.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class UserPersistenceFindByUid implements UserPersistence<Object, User> {

    private final UserRepository repository;

    private final ObjectMapper mapper;

    @Override
    public User execute(Object uid) {
        try {
            return mapper.convertValue(repository.findByUid((String) uid), User.class);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

}
