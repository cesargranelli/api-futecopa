package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.GuessRepository;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import com.sevenine.api.futecopa.application.domain.ports.persistence.GuessPersistence;
import com.sevenine.api.futecopa.application.domain.ports.services.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GuessServiceSaveOrUpdate implements GuessService<Object, List<Game>> {

    private final GuessRepository repository;

    private final List<GuessPersistence<Object, List<Game>>> persistences;

    @Override
    public List<Game> execute(Object... objects) {
        Guess guess = (Guess) objects[0];

        Optional<GuessData> optional = repository.findBySlugAndMatchDay(guess.getSlug(), guess.getMatchDay());

        if (optional.isEmpty()) {
            return persistences.stream().filter(object -> object instanceof GuessPersistenceSave).findAny().orElseThrow()
                    .execute(guess);
        } else {
            return persistences.stream().filter(object -> object instanceof GuessPersistenceUpdate).findAny().orElseThrow()
                    .execute(guess);
        }
    }

}
