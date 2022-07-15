package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Long id;
    private String utcDate;
    private String lastUpdated;
    private Integer matchDay;
    private Team homeTeam;
    private Team awayTeam;
    private Score score;
}
