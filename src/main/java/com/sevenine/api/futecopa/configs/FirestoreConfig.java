package com.sevenine.api.futecopa.configs;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
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

    @Bean
    public Firestore firestore() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/google-credentials.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("${firebase.app}")
                .build();

        FirebaseApp.initializeApp(options);

        return FirestoreClient.getFirestore();
    }

}
