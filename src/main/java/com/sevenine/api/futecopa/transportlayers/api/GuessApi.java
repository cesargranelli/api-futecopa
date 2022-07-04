package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import com.sevenine.api.futecopa.interactors.GuessService;
import com.sevenine.api.futecopa.interactors.PalpiteListaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("guesses")
@RestController
public class GuessApi {

    private final GuessService service;
    private final PalpiteListaService listaService;

    @GetMapping
    public Guess findBySlugAndMatchDay(@RequestHeader String slug, @RequestHeader String matchDay) {
        return service.findBySlugAndRound(slug, matchDay);
    }

    @PostMapping
    public Guess save(@RequestBody Guess guess) {
        return service.save(guess);
    }

    @GetMapping("listar")
    public List<Guess> listar(@RequestHeader String apelido, @RequestHeader String rodada) {
        return listaService.executar(apelido, rodada);
    }

}
