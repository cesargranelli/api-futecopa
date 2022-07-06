package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import com.sevenine.api.futecopa.datasources.firestore.entities.Game;
import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import com.sevenine.api.futecopa.datasources.firestore.entities.MatchDay;
import com.sevenine.api.futecopa.datasources.firestore.repositories.EventRepository;
import com.sevenine.api.futecopa.datasources.firestore.repositories.GuessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveOperations;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuessService {

//    private final GuessRepository guessRepository;
//    private final EventRepository eventRepository;

    private final FirestoreReactiveOperations operations;
    private final Firestore firestore;

    private final MatchService eventService;

    private final ObjectMapper mapper;

    public Object create(Guess guess) {
        FirestoreReactiveOperations parent = operations.withParent(guess);

//        parent.save(guess.getMatchDays().get(0)).block();
//        firestore.collection("guesses").document(guess.getSlug()).collection("matchDays").document(guess.getMatchDays().getId()).set(guess.getMatchDays().getGames());

//        Guess guess1 = new Guess();
//        guess1.setSlug(guess.getSlug());
//        guess1.setMatchDays(operations.withParent(guess).withParent(MatchDay.class).findAll(Game.class).single().block());
        return firestore.collection("guesses").document("rockman-dx").collection("1").document("games").set(guess.getMatchDays().get(0).getGames());
    }

    public Guess findBy(String slug, String matchDay) {
        return null;
//        return guessRepository.findById(slug)
//                .filter(guess -> guess.getEvents().stream()
//                        .filter(event -> event.getGames().stream()
//                                .filter(game -> game.getMatchday() == Integer.getInteger(matchDay)))).single().block();
//        return guessRepository.findAll().singleOrEmpty().blockOptional().orElse(
//                mapper.convertValue(eventRepository.findById(matchDay).blockOptional().orElse(
//                        eventService.findByGames(matchDay)
//                ), Guess.class)
//        );
    }

}
