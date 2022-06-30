package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.datasources.firestore.entities.User;
import com.sevenine.api.futecopa.datasources.firestore.exceptions.FirebaseAuthException;
import com.sevenine.api.futecopa.datasources.firestore.repositories.UserRepository;
import com.sevenine.api.futecopa.interactors.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public User register(Map<String, String> user) {
        try {
            ResponseEntity<Map<String, String>> mapResponse =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<>() {
                            });

            return repository.save(UserMapper.INSTANCE.toUser(user, mapResponse.getBody())).block();
        } catch (HttpClientErrorException e) {
            try {
                FirebaseAuthException firebaseAuthException = objectMapper.readValue(e.getResponseBodyAsString(), FirebaseAuthException.class);
                throw new RuntimeException(firebaseAuthException);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object login(Map<String, String> login) {
        try {
            ResponseEntity<Map<String, String>> mapResponseEntity =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(login), new ParameterizedTypeReference<>() {
                            });

            return repository.findByUid(Objects.requireNonNull(mapResponseEntity.getBody()).get("localId")).single().block();
        } catch (HttpClientErrorException e) {
            try {
                FirebaseAuthException firebaseAuthException = objectMapper.readValue(e.getResponseBodyAsString(), FirebaseAuthException.class);
                throw new RuntimeException(firebaseAuthException);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
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
