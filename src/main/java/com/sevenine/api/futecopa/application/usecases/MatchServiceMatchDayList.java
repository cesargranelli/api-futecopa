package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.rest.apifootball.client.ApiFootballClient;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchesApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.domain.ports.persistence.MatchPersistence;
import com.sevenine.api.futecopa.application.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceMatchDayList implements MatchService<Object, List<Match>> {

    private final ApiFootballClient apiFootballClient;

    private final List<MatchPersistence<Object, List<Match>>> persistences;

    @Autowired
    public MatchServiceMatchDayList(ApiFootballClient apiFootballClient, @Lazy List<MatchPersistence<Object, List<Match>>> persistences) {
        this.apiFootballClient = apiFootballClient;
        this.persistences = persistences;
    }

    @Override
    public List<Match> execute(Object... objects) {
        Integer matchDay = (Integer) objects[0];

        MatchesApi matchesApi = apiFootballClient.matches(String.valueOf(matchDay));

        return persistences.stream().filter(object -> object instanceof MatchPersistenceSaveList).findAny().orElseThrow()
                .execute(matchesApi.getMatches());
    }

}
