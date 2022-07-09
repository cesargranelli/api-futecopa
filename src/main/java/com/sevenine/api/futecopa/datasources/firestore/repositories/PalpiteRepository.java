package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.domain.model.Guess;

import java.util.List;

public interface PalpiteRepository {
    void salvar(String apelido, List<Guess> palpites);

    List<Guess> palpites(String apelido);

    Guess palpite(String apelido, String rodada);
}
