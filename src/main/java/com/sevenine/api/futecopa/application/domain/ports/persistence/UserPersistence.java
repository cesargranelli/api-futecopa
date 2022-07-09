package com.sevenine.api.futecopa.application.domain.ports.persistence;

import org.springframework.stereotype.Component;

@Component("userPersistence")
public interface UserPersistence<P, T> {
    T execute(P object);
}
