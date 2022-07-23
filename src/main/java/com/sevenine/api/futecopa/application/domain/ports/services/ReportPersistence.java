package com.sevenine.api.futecopa.application.domain.ports.services;

public interface ReportPersistence<P, T> {
    T execute(P... objects);
}
