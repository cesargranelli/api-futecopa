package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.interactors.RodadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("rodadas")
@RestController
public class RodadaApi {

    private final RodadaService service;

    @PatchMapping
    public void atualiza() {
        service.executar();
    }

}
