package com.sevenine.api.futecopa.datasources.firebase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.sevenine.api.futecopa.entities.AuthCreate;
import com.sevenine.api.futecopa.entities.AuthCreated;
import com.sevenine.api.futecopa.repositories.AuthCreateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthCreateFirebaseDatasource implements AuthCreateRepository {

    private final ObjectMapper objectMapper;

    @Override
    public AuthCreated create(AuthCreate authCreate) {
        UserRecord.CreateRequest request = objectMapper.convertValue(authCreate, UserRecord.CreateRequest.class);

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return objectMapper.convertValue(userRecord, AuthCreated.class);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }

    }

}
