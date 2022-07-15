package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GameRepository;
import com.sevenine.api.futecopa.application.domain.entities.Bet;
import com.sevenine.api.futecopa.application.services.BetPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BetPersistenceGameList implements BetPersistence<Object, List<Bet>> {

    private final GameRepository repository;

    @Override
    public List<Bet> execute(Object... objects) {
        Integer matchId = (Integer) objects[0];

        Optional<List<GameData>> optional = repository.findByMatchId(matchId);

        return null;
    }

}
