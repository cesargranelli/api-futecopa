package com.sevenine.api.futecopa.interactors.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.datasources.firebase.entities.Registered;
import com.sevenine.api.futecopa.datasources.firestore.exceptions.FirebaseAuthException;
import com.sevenine.api.futecopa.datasources.jpa.entities.UserData;
import com.sevenine.api.futecopa.datasources.jpa.repository.UserRepository;
import com.sevenine.api.futecopa.entities.Register;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.interactors.UserService;
import com.sevenine.api.futecopa.interactors.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements UserService {

    private final UserRepository repository;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    @Override
    public User register(Register register) {
        try {
            ResponseEntity<Registered> registered =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(register), new ParameterizedTypeReference<>() {
                            });

            UserData userData = UserMapper.INSTANCE.toUserData(register, registered.getBody());

            return UserMapper.INSTANCE.toUser(repository.save(userData));
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

}
