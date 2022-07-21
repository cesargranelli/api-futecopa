package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.domain.ports.persistence.MatchPersistence;
import com.sevenine.api.futecopa.application.mappers.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessPersistenceFindByMatchDay implements GuessPersistence<Object, List<Game>> {

    private final GuessRepository guessRepository;

    private final List<MatchPersistence<Object, List<Match>>> persistences;

    @Override
    public List<Game> execute(Object... objects) {
        String slug = (String) objects[0];
        Integer matchDay = (Integer) objects[1];

        Optional<GuessData> optional = guessRepository.findBySlugAndMatchDay(slug, matchDay);

        if (optional.isEmpty()) {
            List<Match> matches = persistences.stream().filter(object -> object instanceof MatchPersistenceFindByMatchDayList).findAny().orElseThrow()
                    .execute(matchDay);

            return GameMapper.INSTANCE.fromMatches(matches);
        }

        return GameMapper.INSTANCE.toGames(optional.orElse(new GuessData()).getGames());
    }

}
