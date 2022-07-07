package com.sevenine.api.futecopa.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Round {
    private Integer matchDay;
    private String name;
    private String stage;
    private LocalDate start;
    private LocalDate end;
    private String status;
}
