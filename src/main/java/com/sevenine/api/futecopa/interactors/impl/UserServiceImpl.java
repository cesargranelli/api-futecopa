package com.sevenine.api.futecopa.interactors.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.datasources.jpa.entities.UserData;
import com.sevenine.api.futecopa.datasources.firestore.exceptions.FirebaseAuthException;
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

@RequiredArgsConstructor
@Service
public class UserServiceImpl {

//    private final UserRepository repository;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public UserData register(Map<String, String> user) {
        try {
            ResponseEntity<Map<String, String>> mapResponse =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<>() {
                            });

            return null;//repository.save(UserMapper.INSTANCE.toUser(user, mapResponse.getBody())).block();
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

            return null;//repository.findByUid(Objects.requireNonNull(mapResponseEntity.getBody()).get("localId")).single().block();
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

    public UserData findByUid(String uid) {
        try {
            return null;//repository.findByUid(uid).single().block();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public UserData findBySlug(String slug) {
        try {
            return null;//repository.findById(slug).single().block();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

}
