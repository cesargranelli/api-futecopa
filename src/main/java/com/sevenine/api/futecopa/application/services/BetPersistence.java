package com.sevenine.api.futecopa.application.services;

public interface BetPersistence<P, T> {
    T execute(P... objects);
}
