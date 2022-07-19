package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.MatchData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.MatchRepository;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.domain.ports.persistence.MatchPersistence;
import com.sevenine.api.futecopa.application.mappers.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MatchPersistenceSaveList implements MatchPersistence<Object, List<Match>> {

    private final MatchRepository repository;

    @Override
    public List<Match> execute(Object... objects) {
        List<MatchApi> matchApiList = (List<MatchApi>) objects[0];

        List<MatchData> matchDataList = repository.saveAll(MatchMapper.INSTANCE.toMatchesData(matchApiList));

        return MatchMapper.INSTANCE.fromMatchesData(matchDataList);
    }

}
