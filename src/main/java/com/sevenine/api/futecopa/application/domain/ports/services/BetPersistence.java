package com.sevenine.api.futecopa.application.domain.ports.services;

public interface BetPersistence<P, T> {
    T execute(P... objects);
}
