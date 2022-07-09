package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private Long id;
    private String winner;
    private String duration;
    private Integer home;
    private Integer away;
}
