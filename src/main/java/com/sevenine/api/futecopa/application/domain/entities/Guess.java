package com.sevenine.api.futecopa.application.domain.entities;

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
