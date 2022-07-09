package com.sevenine.api.futecopa.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.MatchRepository;
import com.sevenine.api.futecopa.adapter.rest.apifootball.client.ApiFootballClient;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchesApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.mapper.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MatchServiceMatchDayList implements MatchService<Object, List<Match>> {

    private final MatchRepository matchRepository;

    private final ApiFootballClient apiFootballClient;

    private final ObjectMapper mapper;

    @Override
    public List<Match> execute(Object... objects) {
        Integer matchDay = (Integer) objects[0];

        MatchesApi matchesApi = apiFootballClient.matches(String.valueOf(matchDay));

        return MatchMapper.INSTANCE.fromMatchesApi(matchesApi.getMatches());
    }

}
