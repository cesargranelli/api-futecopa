package com.sevenine.api.futecopa.application.services;

public interface GuessService<P, T> {
    T execute(P... objects);
}
