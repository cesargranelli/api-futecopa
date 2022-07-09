package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.domain.model.Game;
import com.sevenine.api.futecopa.domain.model.Guess;
import com.sevenine.api.futecopa.domain.port.service.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("guesses")
@RestController
public class GuessController {

    private final GuessService service;

    @PostMapping
    public List<Game> save(@RequestBody Guess guess) {
        return service.save(guess);
    }

    @GetMapping
    public List<Game> findBy(@RequestHeader String slug, @RequestHeader Integer matchDay) {
        return service.findBy(slug, matchDay);
    }

//    @GetMapping("listar")
//    public List<Guess> listar(@RequestHeader String apelido, @RequestHeader String rodada) {
//        return listaService.executar(apelido, rodada);
//    }

}
