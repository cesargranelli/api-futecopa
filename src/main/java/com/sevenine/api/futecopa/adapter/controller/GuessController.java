package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.usecases.GuessPersistenceFindByMatchDay;
import com.sevenine.api.futecopa.application.usecases.GuessPersistenceSaveOrUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("guesses")
@RestController
public class GuessController {

    private final List<GuessPersistence<Object, List<Game>>> persistences;

    @PostMapping
    public List<Game> save(@RequestBody Guess guess) {
        return persistences.stream().filter(object -> object instanceof GuessPersistenceSaveOrUpdate).findAny().orElseThrow()
                .execute(guess);
    }

    @GetMapping
    public List<Game> findBy(@RequestHeader String slug, @RequestHeader Integer matchDay) {
        return persistences.stream().filter(object -> object instanceof GuessPersistenceFindByMatchDay).findAny().orElseThrow()
                .execute(slug, matchDay);
    }

}
