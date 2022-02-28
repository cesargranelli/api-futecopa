package com.sevenine.api.futecopa.datasources.firebase.validator;

import com.google.cloud.firestore.QuerySnapshot;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class QuerySnapshotValidator {

    public static Map<String, Object> getDocumentSnapshot(Future<QuerySnapshot> future) {
        try {
            return future.get().getDocuments().get(0).getData();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
