package com.sevenine.api.futecopa.datasources.firebase.validator;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class QuerySnapshotValidator {

    public static Stream<Map<String, Object>> getDocumentSnapshot(Future<QuerySnapshot> future) {
        try {
            return future.get().getDocuments().stream().map(QueryDocumentSnapshot::getData);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
