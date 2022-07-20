package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.mappers.GameMapper;
import com.sevenine.api.futecopa.application.mappers.GuessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GuessPersistenceSave implements GuessPersistence<Object, List<Game>> {

    private final GuessRepository guessRepository;

    @Override
    public List<Game> execute(Object... objects) {
        Guess guess = (Guess) objects[0];

        GuessData guessData = guessRepository.save(GuessMapper.INSTANCE.toGuessData(guess));

        return GameMapper.INSTANCE.fromGamesData(guessData.getGames());
    }

}
