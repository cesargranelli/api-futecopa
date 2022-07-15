package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Match;
import com.sevenine.api.futecopa.application.services.MatchService;
import com.sevenine.api.futecopa.application.usecases.MatchServiceMatchDayList;
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

    private final List<MatchService<Object, List<Match>>> services;

    @GetMapping
    public List<Match> findBy(@RequestHeader Integer matchDay) {
        return services.stream().filter(object -> object instanceof MatchServiceMatchDayList).findAny().orElseThrow()
                .execute(matchDay);
    }

}
