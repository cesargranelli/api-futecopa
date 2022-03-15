package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Rodada;
import com.sevenine.api.futecopa.entities.Round;

import java.util.List;

public interface RodadaRepository {
    void atualizar(Rodada rodada);

    List<Round> findRounds();

    Round findRoundById(String roundId);

    List<Rodada> getRodadas();
}
