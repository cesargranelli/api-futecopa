package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.datasources.firestore.entities.Round;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface RoundRepository extends FirestoreReactiveRepository<Round> {
}
