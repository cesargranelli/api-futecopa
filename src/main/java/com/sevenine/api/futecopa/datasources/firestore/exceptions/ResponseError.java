package com.sevenine.api.futecopa.datasources.firestore.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseError {
    private int code;
    private String message;
    private String domain;
    private String reason;
    private List<ResponseError> errors;
}
