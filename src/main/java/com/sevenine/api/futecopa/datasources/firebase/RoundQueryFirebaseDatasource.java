package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotValidator;
import com.sevenine.api.futecopa.entities.Round;
import com.sevenine.api.futecopa.repositories.RoundQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RoundQueryFirebaseDatasource implements RoundQueryRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public List<Round> findByRounds() {
        ApiFuture<QuerySnapshot> future = firestore.collection("rounds").get();

        return objectMapper.convertValue(QuerySnapshotValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }

}
