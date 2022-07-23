package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Ranking;
import com.sevenine.api.futecopa.application.domain.ports.services.RankingService;
import com.sevenine.api.futecopa.application.usecases.RankingServiceList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("ranking")
@RestController
public class RankingController {

    private final List<RankingService<Object, List<Ranking>>> services;

    @GetMapping
    public List<Ranking> find() {
        return services.stream().filter(object -> object instanceof RankingServiceList).findAny().orElseThrow()
                .execute();
    }

}
