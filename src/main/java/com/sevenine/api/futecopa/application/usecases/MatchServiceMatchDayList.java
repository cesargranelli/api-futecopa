package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.rest.apifootball.client.ApiFootballClient;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchesApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.mapper.MatchMapper;
import com.sevenine.api.futecopa.application.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MatchServiceMatchDayList implements MatchService<Object, List<Match>> {

    private final ApiFootballClient apiFootballClient;

    @Override
    public List<Match> execute(Object... objects) {
        Integer matchDay = (Integer) objects[0];

        MatchesApi matchesApi = apiFootballClient.matches(String.valueOf(matchDay));

        return MatchMapper.INSTANCE.fromMatchesApi(matchesApi.getMatches());
    }

}
