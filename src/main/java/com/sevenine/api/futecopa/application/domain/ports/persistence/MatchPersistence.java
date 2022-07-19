package com.sevenine.api.futecopa.application.domain.ports.persistence;

import org.springframework.stereotype.Component;

@Component
public interface MatchPersistence<P, T> {
    T execute(P... object);
}
