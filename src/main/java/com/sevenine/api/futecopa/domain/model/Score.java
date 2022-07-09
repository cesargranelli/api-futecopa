package com.sevenine.api.futecopa.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private String winner;
    private String duration;
    private Integer home;
    private Integer away;
}
