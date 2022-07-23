package com.sevenine.api.futecopa.application.domain.ports.services;

public interface ScoringRuleService<P, T> {
    T execute(P... objects);
}
