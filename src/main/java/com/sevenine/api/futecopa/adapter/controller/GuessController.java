package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.services.GuessService;
import com.sevenine.api.futecopa.application.usecases.GuessServiceFindByMatchDay;
import com.sevenine.api.futecopa.application.usecases.GuessServiceSaveOrUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("guesses")
@RestController
public class GuessController {

    private final List<GuessService<Object, List<Game>>> services;

    @PostMapping
    public List<Game> save(@RequestBody Guess guess) {
        return services.stream().filter(object -> object instanceof GuessServiceSaveOrUpdate).findAny().orElseThrow()
                .execute(guess);
    }

    @GetMapping
    public List<Game> findBy(@RequestHeader String slug, @RequestHeader Integer matchDay) {
        return services.stream().filter(object -> object instanceof GuessServiceFindByMatchDay).findAny().orElseThrow()
                .execute(slug, matchDay);
    }

}
