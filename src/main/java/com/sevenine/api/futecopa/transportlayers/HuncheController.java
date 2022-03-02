package com.sevenine.api.futecopa.transportlayers;

import com.sevenine.api.futecopa.entities.Hunche;
import com.sevenine.api.futecopa.repositories.HuncheQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("hunches")
@RestController
public class HuncheController {

    private final HuncheQueryRepository repository;

    @GetMapping("slug/{slug}/round/{round}")
    public List<Hunche> getHunches(@PathVariable String slug, @PathVariable String round) {
        return repository.findBySlugAndRound(slug, round);
    }

}
