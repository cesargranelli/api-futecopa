package com.sevenine.api.futecopa.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Guess {
    private String slug;
    private Integer matchDay;
    private List<Game> games;
}
