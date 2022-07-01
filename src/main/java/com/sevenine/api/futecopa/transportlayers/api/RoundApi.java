package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.datasources.firestore.entities.Round;
import com.sevenine.api.futecopa.interactors.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("rounds")
@RestController
public class RoundApi {

    private final RoundService service;

    @PatchMapping
    public void atualiza() {
//        service.executar();
    }

    @GetMapping
    public List<Round> rounds() {
        return service.rounds();
    }

}
