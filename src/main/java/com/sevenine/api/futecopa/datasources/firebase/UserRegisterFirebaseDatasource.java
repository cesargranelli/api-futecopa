package com.sevenine.api.futecopa.datasources.firebase;

import com.google.cloud.firestore.Firestore;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.repositories.UserRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRegisterFirebaseDatasource implements UserRegisterRepository {

    private final Firestore firestore;

    @Override
    public void create(User newUser) {
        firestore.collection("users").document(newUser.getSlug()).set(newUser);
    }

}
