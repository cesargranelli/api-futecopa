package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotListValidator;
import com.sevenine.api.futecopa.datasources.firestore.entities.Guess;
import com.sevenine.api.futecopa.datasources.firestore.repositories.PalpiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Component
public class GuessFirebaseDatasource implements PalpiteRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public void salvar(String apelido, List<Guess> palpites) {
//        palpites.forEach(palpite -> firestore.collection("palpites").document(apelido)
//                .collection("rodadas").document(palpite.getApelido()).set(palpite, SetOptions.merge())
//        );
    }

    @Override
    public Guess palpite(String apelido, String rodada) {
        Future<DocumentSnapshot> future = firestore.collection("palpites").document(apelido).collection(rodada).document().get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }

    @Override
    public List<Guess> palpites(String apelido) {
        Future<DocumentSnapshot> future = firestore.collection("palpites").document(apelido).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshot(future), new TypeReference<>() {
        });
    }

}
