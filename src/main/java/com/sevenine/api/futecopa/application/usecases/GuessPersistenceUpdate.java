package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.mappers.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessPersistenceUpdate implements GuessPersistence<Object, List<Game>> {

    private final GuessRepository repository;

    @Override
    public List<Game> execute(Object... objects) {
        Guess guess = (Guess) objects[0];

        Optional<GuessData> optional = repository.findBySlugAndMatchDay(guess.getSlug(), guess.getMatchDay());

        optional.orElse(new GuessData()).getGames().forEach(gameData -> {
            guess.getGames().stream()
                    .filter(game -> game.getId().equals(gameData.getMatchId())).findAny()
                    .ifPresent(game -> GameMapper.INSTANCE.updateScores(game, gameData));

            repository.flush();
        });

        return GameMapper.INSTANCE.fromGamesData(repository.findAll().get(0).getGames());
    }

}
