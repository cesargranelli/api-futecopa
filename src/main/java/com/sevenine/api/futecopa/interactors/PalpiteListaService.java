package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.entities.Palpite;
import com.sevenine.api.futecopa.entities.Rodada;
import com.sevenine.api.futecopa.repositories.PalpiteRepository;
import com.sevenine.api.futecopa.repositories.RodadaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class PalpiteListaService {

    private final PalpiteRepository repository;
    private final RodadaRepository rodadaRepository;

    private final ObjectMapper objectMapper;

    public List<Palpite> executar(String apelido, String rodada) {
        List<Palpite> palpites = repository.palpites(apelido);

        List<Rodada> rodadas = rodadaRepository.getRodadas();

        return rodadas.stream().map(rodadaGravada -> objectMapper.convertValue(rodadaGravada, Palpite.class))
                .collect(Collectors.toList());
    }

}
