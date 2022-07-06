package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface GuessRepository /*extends FirestoreReactiveRepository<Guess>*/ {
//    Flux<Guess> findByIdAndEventsGamesMatchday(String slug, String group);
}
