package com.sevenine.api.futecopa.datasources.firestore.repositories;

import com.sevenine.api.futecopa.datasources.firestore.entities.User;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface UserRepository /*extends FirestoreReactiveRepository<User>*/ {
    Flux<User> findByUid(String uid);
}
