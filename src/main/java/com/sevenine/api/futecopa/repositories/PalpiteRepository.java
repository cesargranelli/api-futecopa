package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Palpite;

import java.util.List;

public interface PalpiteRepository {
    void salvar(String apelido, List<Palpite> palpites);

    List<Palpite> palpites(String apelido);

    Palpite palpite(String apelido, String rodada);
}
