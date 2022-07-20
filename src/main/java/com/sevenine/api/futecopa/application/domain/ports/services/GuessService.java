package com.sevenine.api.futecopa.application.domain.ports.services;

public interface GuessService<P, T> {
    T execute(P... objects);
}
