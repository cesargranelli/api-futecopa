package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.datasources.firestore.entities.Event;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface EventRepository extends FirestoreReactiveRepository<Event> {
}
