package com.sevenine.api.futecopa.application.domain.ports.services;

public interface RankingService<P, T> {
    T execute(P... objects);
}
