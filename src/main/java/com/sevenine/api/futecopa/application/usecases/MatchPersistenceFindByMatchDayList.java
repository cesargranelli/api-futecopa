package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.MatchData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.MatchRepository;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.domain.ports.persistence.MatchPersistence;
import com.sevenine.api.futecopa.application.mappers.MatchMapper;
import com.sevenine.api.futecopa.application.domain.ports.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MatchPersistenceFindByMatchDayList implements MatchPersistence<Object, List<Match>> {

    private final MatchRepository repository;

    private final List<MatchService<Object, List<Match>>> services;

    @Override
    public List<Match> execute(Object... objects) {
        Integer matchDay = (Integer) objects[0];

        List<MatchData> matchDataList = repository.findByMatchDay(matchDay);

        if (matchDataList.isEmpty()) {
            return services.stream().filter(object -> object instanceof MatchServiceMatchDayList).findAny().orElseThrow()
                    .execute(matchDay);
        }

        return MatchMapper.INSTANCE.fromMatchesData(matchDataList);
    }

}
