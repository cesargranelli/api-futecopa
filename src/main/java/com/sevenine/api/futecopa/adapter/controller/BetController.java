package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Bet;
import com.sevenine.api.futecopa.application.domain.ports.services.BetPersistence;
import com.sevenine.api.futecopa.application.usecases.BetPersistenceGameList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("bets")
@RestController
public class BetController {

    private final List<BetPersistence<Object, List<Bet>>> services;

    @GetMapping
    public List<Bet> findBy(@RequestHeader Long matchId, @RequestHeader Integer matchDay) {
        return services.stream().filter(object -> object instanceof BetPersistenceGameList).findAny().orElseThrow()
                .execute(matchId, matchDay);
    }

}
