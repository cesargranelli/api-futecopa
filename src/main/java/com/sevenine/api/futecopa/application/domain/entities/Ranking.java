package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranking {
    private Integer position;
    private String slug;
    private Integer round;
    private Integer total;
}
