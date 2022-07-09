package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;

import java.util.List;

public interface GuessService {
    List<Game> save(Guess guess);

    List<Game> findBy(String slug, Integer matchDay);
}
