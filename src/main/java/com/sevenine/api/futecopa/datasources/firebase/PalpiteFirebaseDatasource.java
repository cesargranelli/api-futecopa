package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotListValidator;
import com.sevenine.api.futecopa.entities.Palpite;
import com.sevenine.api.futecopa.repositories.PalpiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Component
public class PalpiteFirebaseDatasource implements PalpiteRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public void salvar(String apelido, List<Palpite> palpites) {
        palpites.forEach(palpite -> firestore.collection("palpites").document(apelido)
                .collection("rodadas").document(palpite.getApelido()).set(palpite, SetOptions.merge())
        );
    }

    @Override
    public Palpite palpite(String apelido, String rodada) {
        Future<DocumentSnapshot> future = firestore.collection("palpites").document(apelido).collection(rodada).document().get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }

    @Override
    public List<Palpite> palpites(String apelido) {
        Future<DocumentSnapshot> future = firestore.collection("palpites").document(apelido).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }

}
