package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.mappers.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessPersistenceFindByMatchDay implements GuessPersistence<Object, List<Game>> {

    private final GuessRepository guessRepository;

    @Override
    public List<Game> execute(Object... objects) {
        String slug = (String) objects[0];
        Integer matchDay = (Integer) objects[1];

        Optional<GuessData> guessDataOptional = guessRepository.findBySlugAndMatchDay(slug, matchDay);

        return GameMapper.INSTANCE.fromGamesData(guessDataOptional.orElse(new GuessData()).getGames());
    }

}
