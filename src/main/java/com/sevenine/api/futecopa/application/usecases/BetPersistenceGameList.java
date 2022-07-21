package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.application.domain.entities.Bet;
import com.sevenine.api.futecopa.application.domain.ports.services.BetPersistence;
import com.sevenine.api.futecopa.application.mappers.GameMapper;
import com.sevenine.api.futecopa.application.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BetPersistenceGameList implements BetPersistence<Object, List<Bet>> {

    private final GuessRepository guessRepository;
    private final UserRepository userRepository;

    @Override
    public List<Bet> execute(Object... objects) {
        Long matchId = (Long) objects[0];
        Integer matchDay = (Integer) objects[1];

        List<GuessData> guessDataList = guessRepository.findByMatchDay(matchDay);

        List<Bet> bets = new ArrayList<>();

        guessDataList.forEach(guessData -> {
            Bet bet = new Bet();

            bet.setUser(UserMapper.INSTANCE.toUser(userRepository.findBySlug(guessData.getSlug())));
            bet.setGame(GameMapper.INSTANCE.toGame(guessData.getGames().stream().filter(gameData ->
                    gameData.getMatchId().equals(matchId)).findAny().orElse(new GameData())));

            bets.add(bet);
        });

        return bets;
    }

}
