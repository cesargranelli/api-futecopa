package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.sevenine.api.futecopa.datasources.firebase.validator.QuerySnapshotListValidator;
import com.sevenine.api.futecopa.entities.Usuario;
import com.sevenine.api.futecopa.repositories.UsuarioQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsuarioQueryFirebaseDatasource implements UsuarioQueryRepository {

    private final Firestore firestore;

    private final ObjectMapper objectMapper;

    @Override
    public Usuario buscaUsuarioApelido(String apelido) {
        ApiFuture<QuerySnapshot> future = firestore.collection("usuarios").whereEqualTo("slug", apelido).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future)
                .findFirst().orElseThrow(), Usuario.class);
    }

    @Override
    public Usuario buscaUsuarioUid(String uid) {
        ApiFuture<QuerySnapshot> future = firestore.collection("usuarios").whereEqualTo("uid", uid).get();

        return objectMapper.convertValue(QuerySnapshotListValidator.getDocumentSnapshotList(future)
                .findFirst().orElseThrow(), Usuario.class);
    }

}
