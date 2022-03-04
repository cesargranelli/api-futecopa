package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotListValidator;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.repositories.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserQueryFirebaseDatasource implements UserQueryRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public User findByUserWithSlug(String slug) {
        ApiFuture<QuerySnapshot> future = firestore.collection("users").whereEqualTo("slug", slug).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future)
                .findFirst().orElseThrow(), User.class);
    }

    @Override
    public User findByUserWithUid(String uid) {
        ApiFuture<QuerySnapshot> future = firestore.collection("users").whereEqualTo("uid", uid).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future)
                .findFirst().orElseThrow(), User.class);
    }

}
