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

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@RestController
public class PalpiteConsultaService {

    private final PalpiteRepository repository;
    private final RodadaRepository rodadaRepository;

    private final ObjectMapper objectMapper;

    public Palpite executar(String apelido, String rodada) {
        Palpite palpite = repository.palpite(apelido, rodada);

        if (isNull(palpite)) {
            List<Rodada> rodadas = rodadaRepository.getRodadas();
        }

        return null;//objectMapper.convertValue(rodadaGravada, Palpite.class).collect(Collectors.toList());
    }

}
