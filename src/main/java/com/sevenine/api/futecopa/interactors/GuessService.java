package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import com.sevenine.api.futecopa.datasources.firestore.repositories.EventRepository;
import com.sevenine.api.futecopa.datasources.firestore.repositories.GuessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuessService {

    private final GuessRepository guessRepository;
    private final EventRepository eventRepository;

    private final MatchService eventService;

    private final ObjectMapper mapper;

    public Guess findBySlugAndRound(String slug, String matchDay) {
        return guessRepository.findById(slug).block();/*.*//*filter(guess -> guess.getEvent().getDocument().equals(matchDay)).block();*/
//        return guessRepository.findAll().singleOrEmpty().blockOptional().orElse(
//                mapper.convertValue(eventRepository.findById(matchDay).blockOptional().orElse(
//                        eventService.findByGames(matchDay)
//                ), Guess.class)
//        );
    }

    public Guess save(Guess guess) {
        return guessRepository.save(guess).block();
    }

}
