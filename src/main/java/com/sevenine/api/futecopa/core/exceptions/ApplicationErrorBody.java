package com.sevenine.api.futecopa.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApplicationErrorBody {
    private String value;
    private String message;
}
