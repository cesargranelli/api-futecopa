package com.sevenine.api.futecopa.application.usecases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.mapper.GameMapper;
import com.sevenine.api.futecopa.application.services.GuessService;
import com.sevenine.api.futecopa.application.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessServiceFindByMatchDay implements GuessService<Object, List<Game>> {

    private final GuessRepository guessRepository;

    private final List<MatchService<Object, List<Match>>> services;

    private final ObjectMapper mapper;

    @Override
    public List<Game> execute(Object... objects) {
        String slug = (String) objects[0];
        Integer matchDay = (Integer) objects[1];

        Optional<GuessData> guessDataOptional = guessRepository.findBySlugAndMatchDay(slug, matchDay);

        if (guessDataOptional.isEmpty()) {
            List<Match> matches = services.stream().filter(object -> object instanceof MatchServiceMatchDayList).findAny().orElseThrow()
                    .execute(matchDay);

            return mapper.convertValue(matches, new TypeReference<>() {
            });
        } else {
            return GameMapper.INSTANCE.fromGamesData(guessDataOptional.get().getGames());
        }
    }

}
