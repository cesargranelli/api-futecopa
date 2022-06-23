package com.sevenine.api.futecopa.interactors;

import com.sevenine.api.futecopa.entities.Palpite;
import com.sevenine.api.futecopa.repositories.PalpiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PalpiteSalvaService {

    private final PalpiteRepository repository;

    public void executar(String apelido, List<Palpite> palpites) {
        repository.salvar(apelido, palpites);
    }

}
