package com.sevenine.api.futecopa.application.domain.ports.services;

public interface MatchService<P, T> {
    T execute(P... objects);
}
