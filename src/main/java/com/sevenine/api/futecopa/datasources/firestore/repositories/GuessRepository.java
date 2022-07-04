package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface GuessRepository extends FirestoreReactiveRepository<Guess> {
}
