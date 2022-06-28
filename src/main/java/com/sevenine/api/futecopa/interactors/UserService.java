package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.sevenine.api.futecopa.datasources.firestore.entities.User;
import com.sevenine.api.futecopa.datasources.firestore.repositories.UserRepository;
import com.sevenine.api.futecopa.interactors.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final ObjectMapper objectMapper;

    public User register(Map<String, String> user) {
        UserRecord.CreateRequest request = objectMapper.convertValue(user, UserRecord.CreateRequest.class);

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

            return repository.save(UserMapper.INSTANCE.toUser(user, userRecord)).block();
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUid(String uid) {
        try {
            return repository.findByUid(uid).single().block();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public User findBySlug(String slug) {
        try {
            return repository.findById(slug).single().block();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

}
