package com.sevenine.api.futecopa.application.usecases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.mapper.GameMapper;
import com.sevenine.api.futecopa.application.mapper.GuessMapper;
import com.sevenine.api.futecopa.application.services.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessServiceSaveOrUpdate implements GuessService<Object, List<Game>> {

    private final GuessRepository guessRepository;

    private final ObjectMapper mapper;

    @Override
    public List<Game> execute(Object... objects) {
        Guess guess = (Guess) objects[0];

        Optional<GuessData> optional = guessRepository.findBySlugAndMatchDay(guess.getSlug(), guess.getMatchDay());

        if (optional.isEmpty()) {
            guessRepository.save(GuessMapper.INSTANCE.toGuessData(guess));
        } else {
            optional.get().getGames().forEach(gameData -> guess.getGames().stream()
                    .filter(game -> game.getId().equals(gameData.getMatchId())).findAny()
                    .ifPresent(game -> GameMapper.INSTANCE.updateScores(game, gameData)));

            guessRepository.flush();
        }

        return GameMapper.INSTANCE.fromGamesData(guessRepository.findAll().get(0).getGames());
    }

}
