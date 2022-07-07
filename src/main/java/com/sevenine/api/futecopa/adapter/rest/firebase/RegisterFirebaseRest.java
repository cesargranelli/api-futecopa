package com.sevenine.api.futecopa.adapter.rest.firebase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.rest.firebase.payload.LogonPayload;
import com.sevenine.api.futecopa.adapter.rest.firebase.payload.RegisteredPayload;
import com.sevenine.api.futecopa.datasources.firestore.exceptions.FirebaseAuthException;
import com.sevenine.api.futecopa.domain.model.Login;
import com.sevenine.api.futecopa.domain.model.Logon;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.model.Registered;
import com.sevenine.api.futecopa.domain.port.rest.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class RegisterFirebaseRest implements UserRest {

    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    @Override
    public Registered register(Register register) {
        try {
            ResponseEntity<RegisteredPayload> registered =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(register), new ParameterizedTypeReference<>() {
                            });

            return mapper.convertValue(registered.getBody(), Registered.class);
        } catch (HttpClientErrorException e) {
            try {
                FirebaseAuthException firebaseAuthException = mapper.readValue(e.getResponseBodyAsString(), FirebaseAuthException.class);
                throw new RuntimeException(firebaseAuthException);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Logon login(Login login) {
        try {
            ResponseEntity<LogonPayload> logon =
                    restTemplate.exchange("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCVQjL7W-pp3xSXeXhcQEjF14zzEM11GO0",
                            HttpMethod.POST, new HttpEntity<>(login), new ParameterizedTypeReference<>() {
                            });

            return mapper.convertValue(logon.getBody(), Logon.class);
        } catch (HttpClientErrorException e) {
            try {
                FirebaseAuthException firebaseAuthException = mapper.readValue(e.getResponseBodyAsString(), FirebaseAuthException.class);
                throw new RuntimeException(firebaseAuthException);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
