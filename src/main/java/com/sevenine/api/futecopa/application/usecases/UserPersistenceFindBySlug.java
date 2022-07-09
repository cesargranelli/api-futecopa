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
public class UserPersistenceFindBySlug implements UserPersistence<Object, User> {

    private final UserRepository repository;

    private final ObjectMapper mapper;

    @Override
    public User execute(Object slug) {
        try {
            return mapper.convertValue(repository.findBySlug((String) slug), User.class);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

}
