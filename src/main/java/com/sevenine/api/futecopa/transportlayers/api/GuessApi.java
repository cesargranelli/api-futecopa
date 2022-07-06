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

    @PostMapping
    public Object create(@RequestBody Guess guess) {
        return service.create(guess);
    }

    @GetMapping
    public Guess findBy(@RequestHeader String slug, @RequestHeader String matchDay) {
        return service.findBy(slug, matchDay);
    }

    @GetMapping("listar")
    public List<Guess> listar(@RequestHeader String apelido, @RequestHeader String rodada) {
        return listaService.executar(apelido, rodada);
    }

}
