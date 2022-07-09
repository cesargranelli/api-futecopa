package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Round;
import com.sevenine.api.futecopa.application.domain.ports.persistence.RoundPersistence;
import com.sevenine.api.futecopa.application.usecases.RoundPersistenceList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("rounds")
@RestController
public class RoundController {

    private final List<RoundPersistence<Object, List<Round>>> persistences;

    @GetMapping
    public List<Round> rounds() {
        return persistences.stream().filter(object -> object instanceof RoundPersistenceList).findAny().orElseThrow()
                .execute(null);
    }

}
