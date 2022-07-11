package com.sevenine.api.futecopa.application.domain.ports.persistence;

public interface RoundPersistence<P, T> {
    T execute(P object);
}
