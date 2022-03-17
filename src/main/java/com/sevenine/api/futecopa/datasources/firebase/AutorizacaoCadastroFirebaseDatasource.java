package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.sevenine.api.futecopa.entities.UsuarioCadastrado;
import com.sevenine.api.futecopa.entities.UsuarioCadastro;
import com.sevenine.api.futecopa.repositories.AutorizacaoCadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AutorizacaoCadastroFirebaseDatasource implements AutorizacaoCadastroRepository {

    private final ObjectMapper objectMapper;

    @Override
    public UsuarioCadastrado create(UsuarioCadastro usuarioCadastro) {
        UserRecord.CreateRequest request = objectMapper.convertValue(usuarioCadastro, UserRecord.CreateRequest.class);

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return objectMapper.convertValue(userRecord, UsuarioCadastrado.class);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

}
