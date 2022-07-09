package com.sevenine.api.futecopa.domain.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.MatchData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.MatchRepository;
import com.sevenine.api.futecopa.datasources.apifootball.ApiFootballClient;
import com.sevenine.api.futecopa.datasources.apifootball.entities.MatchesApi;
import com.sevenine.api.futecopa.domain.model.Game;
import com.sevenine.api.futecopa.domain.model.Guess;
import com.sevenine.api.futecopa.domain.port.service.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Service
public class GuessServiceImpl implements GuessService {

    private final GuessRepository guessRepository;
    private final MatchRepository matchRepository;

    private final ApiFootballClient apiFootballClient;

    private final ObjectMapper mapper;

    @Override
    public List<Game> save(Guess guess) {
        Optional<GuessData> optional = guessRepository.findBySlugAndMatchDay(guess.getSlug(), guess.getMatchDay());

        if (optional.isEmpty()) {
            guessRepository.save(mapper.convertValue(guess, GuessData.class));
        } else {
            optional.get().setGames(mapper.convertValue(guess.getGames(), new TypeReference<>() {
            }));

            guessRepository.flush();
        }

        return mapper.convertValue(guessRepository.findAll().get(0).getGames(), new TypeReference<>() {
        });
    }

    @Override
    public List<Game> findBy(String slug, Integer matchDay) {
        Optional<GuessData> guessDataOptional = guessRepository.findBySlugAndMatchDay(slug, matchDay);

        if (guessDataOptional.isEmpty()) {
            Optional<List<MatchData>> matchDataOptional = matchRepository.findByMatchDay(matchDay);

            if (requireNonNull(matchDataOptional.orElse(null)).isEmpty()) {
                MatchesApi matchesApi = apiFootballClient.matches(String.valueOf(matchDay));

                matchesApi.getMatches().forEach(matchApi -> {
                    matchRepository.save(mapper.convertValue(matchApi, MatchData.class));
                });

                Guess guess = new Guess();
                guess.setSlug(slug);
                guess.setMatchDay(matchDay);
                guess.setGames(mapper.convertValue(matchesApi.getMatches(), new TypeReference<>() {
                }));

                guessRepository.save(mapper.convertValue(guess, GuessData.class));

                return mapper.convertValue(matchesApi.getMatches(), new TypeReference<>() {
                });
            } else {
                return mapper.convertValue(matchDataOptional.get(), new TypeReference<>() {
                });
            }

        } else {
            return mapper.convertValue(guessDataOptional.get().getGames(), new TypeReference<>() {
            });
        }
    }

}
