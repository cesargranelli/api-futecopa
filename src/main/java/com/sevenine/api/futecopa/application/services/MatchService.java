package com.sevenine.api.futecopa.application.services;

public interface MatchService<P, T> {
    T execute(P... objects);
}
