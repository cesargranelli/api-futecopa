package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.entities.Palpite;
import com.sevenine.api.futecopa.interactors.PalpiteConsultaService;
import com.sevenine.api.futecopa.interactors.PalpiteListaService;
import com.sevenine.api.futecopa.interactors.PalpiteSalvaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("palpites")
@RestController
public class PalpiteApi {

    private final PalpiteSalvaService salvaService;
    private final PalpiteConsultaService consultaService;
    private final PalpiteListaService listaService;

    @PostMapping
    public void salvar(@RequestHeader String apelido, @RequestBody List<Palpite> palpites) {
        salvaService.executar(apelido, palpites);
    }

    @GetMapping("consultar")
    public Palpite consultar(@RequestHeader String apelido, @RequestHeader String rodada) {
        return consultaService.executar(apelido, rodada);
    }

    @GetMapping("listar")
    public List<Palpite> listar(@RequestHeader String apelido, @RequestHeader String rodada) {
        return listaService.executar(apelido, rodada);
    }

}
