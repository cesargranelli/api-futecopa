package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.domain.ports.persistence.MatchPersistence;
import com.sevenine.api.futecopa.application.usecases.MatchPersistenceFindByMatchDayList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("matches")
@RestController
public class MatchController {

    private final List<MatchPersistence<Object, List<Match>>> persistences;

    @GetMapping
    public List<Match> findBy(@RequestHeader Integer matchDay) {
        return persistences.stream().filter(object -> object instanceof MatchPersistenceFindByMatchDayList).findAny().orElseThrow()
                .execute(matchDay);
    }

}
