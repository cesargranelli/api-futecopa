package com.sevenine.api.futecopa.application.domain.ports.persistence;

public interface GuessPersistence<P, T> {
    T execute(P... objects);
}
