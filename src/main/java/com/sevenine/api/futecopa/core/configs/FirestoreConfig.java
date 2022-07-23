package com.sevenine.api.futecopa.core.configs;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfig implements CredentialsProvider {

    @Bean
    @Override
    public Credentials getCredentials() throws IOException {
        return GoogleCredentials.fromStream(new FileInputStream("src/main/resources/google-credentials.json"));
    }

}
