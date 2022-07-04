package com.sevenine.api.futecopa.datasources.firestore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private long id;
    private String utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private Team homeTeam;
    private Team awayTeam;
    private Score score;
}
