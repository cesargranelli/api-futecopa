package com.sevenine.api.futecopa.datasources.firestore.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirebaseAuthException extends RuntimeException {
    private ResponseError error;
}
