package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotListValidator;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotValidator;
import com.sevenine.api.futecopa.entities.Rodada;
import com.sevenine.api.futecopa.application.domain.entities.Round;
import com.sevenine.api.futecopa.repositories.RodadaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Component
public class RodadaFirebaseDatasource implements RodadaRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public void atualizar(Rodada rodada) {
        firestore.collection("rodadas").document(rodada.getApelido()).set(rodada);
    }

    @Override
    public List<Round> findRounds() {
        Future<QuerySnapshot> future = firestore.collection("rounds").get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future), new TypeReference<>() {
        });
    }

    @Override
    public Round findRoundById(String roundId) {
        Future<QuerySnapshot> future =
                firestore.collection("rounds").whereEqualTo("round", Integer.valueOf(roundId)).get();

        return objectMapper.convertValue(QuerySnapshotValidator.getDocumentSnapshot(future), Round.class);
    }

    @Override
    public List<Rodada> getRodadas() {
        Future<QuerySnapshot> future = firestore.collection("rodadas").get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future), new TypeReference<>() {
        });
    }

}
