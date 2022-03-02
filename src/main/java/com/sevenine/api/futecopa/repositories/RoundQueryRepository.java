package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Round;

import java.util.List;

public interface RoundQueryRepository {
    List<Round> findByRounds();
}
