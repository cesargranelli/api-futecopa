package com.sevenine.api.futecopa.transportlayers;

import com.sevenine.api.futecopa.entities.Round;
import com.sevenine.api.futecopa.repositories.RoundQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("rounds")
@RestController
public class RoundController {

    private final RoundQueryRepository repository;

    @GetMapping
    public List<Round> getRounds() {
        return repository.findByRounds();
    }

}
