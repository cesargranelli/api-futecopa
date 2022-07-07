package com.sevenine.api.futecopa.adapter.controller;

import com.sevenine.api.futecopa.domain.model.Round;
import com.sevenine.api.futecopa.domain.port.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("rounds")
@RestController
public class RoundController {

    private final RoundService service;

    @GetMapping
    public List<Round> rounds() {
        return service.rounds();
    }

    @PatchMapping
    public void atualiza() {
//        service.executar();
    }

}
