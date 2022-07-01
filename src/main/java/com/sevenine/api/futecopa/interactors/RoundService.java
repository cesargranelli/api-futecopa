package com.sevenine.api.futecopa.interactors;

import com.sevenine.api.futecopa.datasources.firestore.entities.Round;
import com.sevenine.api.futecopa.datasources.firestore.repositories.RoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoundService {

    private final RoundRepository repository;

    public List<Round> rounds() {
        return repository.findAll().collectList().block();
    }

}
