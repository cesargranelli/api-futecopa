package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GameRepository;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.application.domain.entities.Bet;
import com.sevenine.api.futecopa.application.mappers.BetMapper;
import com.sevenine.api.futecopa.application.domain.ports.services.BetPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BetPersistenceGameList implements BetPersistence<Object, List<Bet>> {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    @Override
    public List<Bet> execute(Object... objects) {
        Long matchId = (Long) objects[0];
        Integer matchDay = (Integer) objects[1];

        Optional<List<GameData>> optional = gameRepository.findByMatchId(matchId);

//        List<UserData> userDataList =
//                userRepository.findByAllSlug(optional.get().stream().map(GameData::getGuess)
//                        .collect(Collectors.toList())
//                        .stream().map(GuessData::getSlug)
//                        .collect(Collectors.toList()));

        List<Bet> bets = new ArrayList<>();

        BetMapper.INSTANCE.insertGameList(optional.orElse(null), bets);

        return bets;
    }

}
