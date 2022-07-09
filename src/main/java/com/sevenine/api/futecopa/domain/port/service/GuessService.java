package com.sevenine.api.futecopa.domain.port.service;

import com.sevenine.api.futecopa.domain.model.Game;
import com.sevenine.api.futecopa.domain.model.Guess;

import java.util.List;

public interface GuessService {
    List<Game> save(Guess guess);

    List<Game> findBy(String slug, Integer matchDay);
}
