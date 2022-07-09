package com.sevenine.api.futecopa.adapter.rest.apifootball;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.rest.apifootball.client.ApiFootballClient;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchesApi;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.ports.rest.MatchesByMatchDayRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MatchesByMatchDayApiFootball implements MatchesByMatchDayRest {

    private final ApiFootballClient apiFootballClient;

    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    @Override
    public List<Game> matches(String matchDay) {
        MatchesApi matchesApi = apiFootballClient.matches(String.valueOf(matchDay));

        return mapper.convertValue(matchesApi, new TypeReference<>() {
        });
    }

}
