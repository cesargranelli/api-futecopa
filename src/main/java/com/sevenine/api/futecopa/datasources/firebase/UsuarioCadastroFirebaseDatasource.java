package com.sevenine.api.futecopa.datasources.firebase;

import com.google.cloud.firestore.Firestore;
import com.sevenine.api.futecopa.entities.Usuario;
import com.sevenine.api.futecopa.repositories.UsuarioCadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsuarioCadastroFirebaseDatasource implements UsuarioCadastroRepository {

    private final Firestore firestore;

    @Override
    public void create(Usuario novoUsuario) {
        firestore.collection("usuarios").document(novoUsuario.getSlug()).set(novoUsuario);
    }

}
