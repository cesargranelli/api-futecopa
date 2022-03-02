package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotValidator;
import com.sevenine.api.futecopa.entities.Hunche;
import com.sevenine.api.futecopa.repositories.HuncheQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class HuncheQueryFirebaseDatasource implements HuncheQueryRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public List<Hunche> findBySlugAndRound(String slug, String round) {
        ApiFuture<QuerySnapshot> future =
                firestore.collection("hunches").document(slug).collection(round).get();

        return objectMapper.convertValue(QuerySnapshotValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }
}
